package com.platform.admin.webapp.controller;

import com.platform.admin.api.RoleService;
import com.platform.admin.api.SessionService;
import com.platform.admin.api.UserService;
import com.platform.admin.api.vo.RoleVO;
import com.platform.admin.api.vo.UserVO;
import com.platform.admin.common.result.JsonResult;
import com.platform.admin.common.security.MD5Utils;
import com.platform.admin.security.Constants;
import com.platform.admin.security.UserInfo;
import com.platform.admin.security.config.SecurityConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_USER表控制器
 */

@Controller
@RequestMapping("/umplatform/user")
public class UserController implements Constants {
    private static final Log log = LogFactory.getLog(UserController.class);

    @javax.annotation.Resource
    private SecurityConfig securityConfig;

    @javax.annotation.Resource
    private UserService userService;

    @javax.annotation.Resource
    private RoleService roleService;

    @javax.annotation.Resource
    private SessionService sessionService;

    @RequestMapping(value = "/index")
    public String index() {
        return "/user/index";
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(String id) {

        ModelAndView mav = new ModelAndView("/user/edit");
        JsonResult result = new JsonResult();
        try {
            UserVO userVO = new UserVO(id);
            UserVO userInfo = userService.get(userVO);
            List<RoleVO> data = roleService.queryAll();
            mav.addObject("roleList", data);
            mav.addObject("userInfo", userInfo);
            //查询记录
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return mav;
    }

    @RequestMapping(value = "/toEditBasicInfo")
    public ModelAndView editBasicInfo(String id) {

        ModelAndView mav = new ModelAndView("/user/editBasicInfo");
        JsonResult result = new JsonResult();
        try {
            UserVO userVO = new UserVO(id);
            UserVO userInfo = userService.get(userVO);
            List<RoleVO> data = roleService.queryAll();
            mav.addObject("roleList", data);
            mav.addObject("userInfo", userInfo);
            //查询记录
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return mav;
    }

    @RequestMapping(value = "/toEditPsw")
    public ModelAndView toEditPsw(String id) {

        ModelAndView mav = new ModelAndView("/user/editPsw");
        JsonResult result = new JsonResult();
        try {
            UserVO userVO = new UserVO(id);
            UserVO userInfo = userService.get(userVO);
            mav.addObject("userInfo", userInfo);
            //查询记录
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return mav;
    }

    @RequestMapping(value = "/add")
    public ModelAndView add(String treeId) {
        ModelAndView mav = new ModelAndView("/user/add");
        try {
            List<RoleVO> data = roleService.queryAll();
            mav.addObject("list", data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

    /**
     * 查询列表页
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public JsonResult list(UserVO user) {
        JsonResult result = new JsonResult();
        try {
            // 设置结果集
            result.put("list", userService.query(user));
            result.put("rowCount", userService.queryCount(user));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("查询异常", e);
            result.setMessage("查询异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 新增记录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/post")
    @ResponseBody
    public JsonResult post(UserVO user) throws Exception {
        JsonResult result = new JsonResult();
        try {

            //密码加密
            user.setPassword(MD5Utils.MD5(user.getPassword()));
            // 默认值设置
            user.setLocked(0);
            user.setIsAdministrator(0);
            //持久化
            userService.insert(user);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("提交数据异常", e);
            result.setMessage("提交数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 删除记录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult delete(UserVO user) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //删除记录
            if (user != null && !StringUtils.isEmpty(user.getId())) {
                userService.delete(user);
                result.setSuccess(true);
            } else {
                result.setMessage("未删除任何数据，选择项为空");
                result.setSuccess(false);
            }
        } catch (Exception e) {
            log.error("删除数据异常", e);
            result.setMessage("删除数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 删除记录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/lock")
    @ResponseBody
    public JsonResult lock(UserVO user) throws Exception {
        JsonResult result = new JsonResult();
        try {
            if (user != null && !StringUtils.isEmpty(user.getIds())) {
                userService.lock(user);
                result.setSuccess(true);
            } else {
                result.setMessage("未删除任何数据，选择项为空");
                result.setSuccess(false);
            }
        } catch (Exception e) {
            log.error("操作异常", e);
            result.setMessage("操作发生异常");
            result.setSuccess(false);
        }
        return result;
    }


    /**
     * 更新记录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/put")
    @ResponseBody
    public JsonResult put(UserVO user) throws Exception {
        JsonResult result = new JsonResult();
        try {
            String rols = user.getRoles();
            //更新记录
            UserVO userInfo = userService.get(user);
            // 默认值设置
            userInfo.setLocked(0);
            userInfo.setIsAdministrator(0);
            if (!userInfo.getPassword().equalsIgnoreCase(user.getPassword())) {
                user.setPassword(MD5Utils.MD5(user.getPassword()));
            }
            userInfo.setRoles(user.getRoles());
            userInfo.setUserName(user.getUserName());
            userInfo.setRealName(user.getRealName());
            userInfo.setEmail(user.getEmail());
            userInfo.setMobileNo(user.getMobileNo());
            userInfo.setPhoneNo(user.getPhoneNo());
            userInfo.setOrganizationId(user.getOrganizationId());
            userService.update(userInfo);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 更新基本资料
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/editBasicInfo")
    @ResponseBody
    public JsonResult editBasicInfo(UserVO user) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            UserVO userInfo = userService.get(user);
            if (!userInfo.getPassword().equalsIgnoreCase(user.getPassword())) {
                user.setPassword(MD5Utils.MD5(user.getPassword()));
            }
            userService.update(user);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/editPwd")
    @ResponseBody
    public JsonResult editPwd(UserVO user) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            UserVO userInfo = userService.get(user);
            userInfo.setPassword(MD5Utils.MD5(user.getNewPassword()));
            userService.update(userInfo);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/checkPassword")
    @ResponseBody
    public JsonResult checkPassword(UserVO user) {
        JsonResult result = new JsonResult();
        try {
            UserVO userInfo = userService.get(user);
            if (!userInfo.getPassword().equalsIgnoreCase(MD5Utils.MD5(user.getPassword()))) {
                result.setSuccess(false);
            } else {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 记录详情
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public JsonResult get(UserVO user) throws Exception {
        JsonResult result = new JsonResult();
        try {
            UserVO userInfo = userService.get(user);
            //查询记录
            result.setData(userInfo);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 从cookie中读取用户信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getUserInfoFormCookie")
    @ResponseBody
    public JsonResult getUserInfoFormCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        UserInfo uInfo = sessionService.readSession(request.getSession().getId(), securityConfig.getSecuritKey());
        UserVO user = new UserVO();
        user.setId(uInfo.getUserId());
        try {
            UserVO userInfo = userService.get(user);
            //查询记录
            result.setData(userInfo);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 查询用户名称是否重复
     *
     * @param userName 用户名
     * @return
     */
    @RequestMapping(value = "/getUserByName")
    @ResponseBody
    public JsonResult getUserByName(String userName) {
        JsonResult result = new JsonResult();
        try {
            UserVO userVO = new UserVO();
            userVO.setUserName(userName);
            userVO.setStart(0);
            userVO.setLimit(10);
            List<UserVO> list = userService.query(userVO);
            if (list == null || list.size() == 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //查询记录
            result.setSuccess(false);
        }
        return result;
    }


    /**
     * 获取用户基本信息
     *
     * @return
     */
    @RequestMapping(value = "/getBasicInfo")
    @ResponseBody
    public JsonResult getBasicInfo(HttpServletRequest request) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //查询记录
            //读取登录信息
            UserInfo userInfo = sessionService.readSession(request.getSession().getId(), securityConfig.getSecuritKey());
            UserVO user = new UserVO();
            user.setId(userInfo.getUserId());
            result.setData(userService.get(user));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
