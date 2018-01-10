package com.platform.admin.webapp.controller;

import com.platform.admin.api.SessionService;
import com.platform.admin.api.UserService;
import com.platform.admin.api.vo.SessionUserVO;
import com.platform.admin.api.vo.UserVO;
import com.platform.admin.common.result.JsonResult;
import com.platform.admin.common.security.MD5Utils;
import com.platform.admin.common.util.FileUtils;
import com.platform.admin.common.util.VerifyCodeUtils;
import com.platform.admin.security.Constants;
import com.platform.admin.security.UserInfo;
import com.platform.admin.security.config.SecurityConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

//import org.apache.commons.beanutils.PropertyUtilsBean;

/**
 * Created by yankun on 2015/6/24 0024.
 */
@Controller
public class IndexController implements Constants {

    private static final Log logger = LogFactory.getLog(IndexController.class);

    @javax.annotation.Resource
    private SecurityConfig securityConfig;

    @javax.annotation.Resource
    private UserService userServiceImpl;

    @javax.annotation.Resource
    private SessionService sessionService;


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/interceptor")
    @ResponseBody
    public JsonResult interceptor(HttpServletRequest request, HttpServletResponse response) {
        JsonResult jsonResult = new JsonResult();
        try {
            HashMap map = new HashMap();
            UserInfo userInfo = sessionService.readSession(request.getSession().getId(), securityConfig.getSecuritKey());
            if (userInfo != null) {
                jsonResult.setSuccess(true);
                map.put("userId", userInfo.getUserId());
                map.put("ip", request.getLocalAddr());
                map.put("port", request.getLocalPort());
                map.put("path", "index");
                jsonResult.setData(map);
            } else {
                jsonResult.setSuccess(false);
                jsonResult.setMessage("用户没有登陆!");
            }
        } catch (Exception e) {
            jsonResult.setSuccess(false);
            jsonResult.setMessage("系统异常!");
        }
        return jsonResult;
    }


    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, String backUrl) {
        String desKey = securityConfig.getSecuritKey();
        //写backurl
        if (!StringUtils.isEmpty(backUrl))
            sessionService.writeBackUrl(request.getSession().getId(), desKey, backUrl);
        return "login";
    }


    @RequestMapping("/authenticate")
    @ResponseBody
    public JsonResult authenticate(HttpServletRequest request, HttpServletResponse response, String userName, String password, String imagecode, String backUrl) {
        JsonResult jsonResult = new JsonResult();
        String desKey = securityConfig.getSecuritKey();
        //读取验证码
        String verifyCode = sessionService.readRandCode(request.getSession().getId(), desKey);
        try {
            if (verifyCode != null && imagecode != null && verifyCode.toUpperCase().equalsIgnoreCase(imagecode.toUpperCase())) {//验证码
                UserVO user = userServiceImpl.get(new UserVO(null, userName));
                String pwd = MD5Utils.MD5(password);
                if (user != null) {
                    if (user.getIsAdministrator() != 1 && user.getLocked() == 1) {
                        jsonResult.setSuccess(false);
                        jsonResult.setMessage("该用户已被锁定，请与管理员联系");
                    } else {
                        if (pwd.equalsIgnoreCase(user.getPassword())) {
                            //登录成功
                            jsonResult.setSuccess(true);
                            jsonResult.setMessage("登录认证成功。");
                            //写backUrl
                            jsonResult.put(BACK_URL, sessionService.readBackUrl(request.getSession().getId(), desKey));
                            //清除backUrl
                            sessionService.deleteBackUrl(request.getSession().getId(), desKey);
                            //设置登录用户信息
                            UserInfo userInfo = new UserInfo();
                            userInfo.setUserId(user.getId());
                            userInfo.setUserName(user.getUserName());
                            userInfo.setAreaCode(user.getAreaCode());
                            userInfo.setRoleIds(user.getRoles());
                            userInfo.setOrganizationCode(user.getOrganizationId());
                            userInfo.setAdministrator(user.getIsAdministrator().intValue() == 1 ? true : false);
                            //写入cookie
                            SessionUserVO parm = new SessionUserVO(userInfo, request.getSession().getId(), desKey);
                            sessionService.writeSession(parm);
                            sessionService.deleteRanCode(request.getSession().getId(), desKey);
                            //更新登 录时间和次数
                            if (user.getLoginCount() == null) {
                                user.setLoginCount(1);
                            } else {
                                user.setLoginCount(user.getLoginCount() + 1);
                            }
                            user.setLastLoginTime(new Date());
                            //清除验证码

                            userServiceImpl.update(user);
                        } else {
                            jsonResult.setSuccess(false);
                            jsonResult.setMessage("认证失败，用户或密码错误");
                        }
                    }
                } else {
                    jsonResult.setSuccess(false);
                    jsonResult.setMessage("认证失败，用户不存在");
                }
            } else {
                jsonResult.setSuccess(false);
                jsonResult.setMessage("图形验证码输出错误");
            }
        } catch (Exception e) {
            logger.error("登录异常", e);
            jsonResult.setSuccess(false);
            jsonResult.setMessage("认证用户身份信息时异常");
        }

        return jsonResult;
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        String desKey = securityConfig.getSecuritKey();
        //清除用户cookie
        sessionService.deleteSession(request.getSession().getId(), desKey);
        return "login";
    }

    @RequestMapping("/imageCode")
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String desKey = securityConfig.getSecuritKey();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);


        //写入Cookie
        sessionService.writeRandCode(request.getSession().getId(), verifyCode, desKey);
        //生成图片
        int w = 200, h = 80;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    /**
     * 获取ICON
     *
     * @param key
     * @param iconType
     * @param start
     * @param limit
     * @return
     */
    @RequestMapping("/getIcons")
    @ResponseBody
    public JsonResult getIcons(String key, String iconType, int start, int limit) {
        JsonResult jsonResult = new JsonResult();

        //获取图标的 物理路径 =  组件的物理路径 +　图标的相对路径
        String iconPath = new File(getClass().getResource("/").getFile()).getParentFile().getParent() + "/";
        //获取图片列表
        List<Map<String, String>> dir = FileUtils.getPicFileList(iconPath);
        List<Map<String, String>> icons = new ArrayList<Map<String, String>>();

        //关键字过滤
        if (StringUtils.isEmpty(key)) {
            icons.addAll(dir);
        } else {
            for (Map<String, String> map : dir) {
                if (map.get("icon").indexOf(key.trim()) != -1) {
                    icons.add(map);
                }
            }
        }

        //分页
        List<Map<String, String>> pageIcons = new ArrayList<Map<String, String>>();
        int totalCount = icons.size();
        if (icons.size() > 0) {
            if (icons.size() > (start + limit)) {
                pageIcons = icons.subList(start, start + limit);
            } else {
                pageIcons = icons.subList(start, totalCount);
            }
        }
        jsonResult.setSuccess(true);
        jsonResult.put("list", pageIcons);
        jsonResult.put("rowCount", totalCount);

        //返回
        return jsonResult;
    }


    /**
     * 实体类对象转为Map类型
     * @param obj
     * @return
     */
//    private static Map<String, Object> beanToMap(Object obj) {
//        Map<String, Object> params = new HashMap<String, Object>(0);
//        try {
//            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
//            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
//            for (int i = 0; i < descriptors.length; i++) {
//                String name = descriptors[i].getName();
//                if (!"class".equals(name)) {
//                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
//                }
//            }
//        } catch (Exception e) {
//            logger.error("beanToMap error",e);
//        }
//        return params;
//    }
}
