package com.platform.admin.webapp.controller;

import com.platform.admin.api.ApplicationService;
import com.platform.admin.api.SessionService;
import com.platform.admin.api.vo.ApplicationVO;
import com.platform.admin.common.result.JsonResult;
import com.platform.admin.security.Constants;
import com.platform.admin.security.UserInfo;
import com.platform.admin.security.config.SecurityConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_APPLICATION表控制器
 */

@Controller
@RequestMapping("/umplatform/application")
public class ApplicationController implements Constants {
    private static final Log log = LogFactory.getLog(ApplicationController.class);

    @javax.annotation.Resource
    private ApplicationService applicationServiceImpl;

    @javax.annotation.Resource
    private SessionService redisCacheSessionServiceImpl;

    @javax.annotation.Resource
    private SecurityConfig securityConfig;

    @RequestMapping(value = "/viewApplication")
    public ModelAndView view(ApplicationVO vo) {
        ModelAndView mav = new ModelAndView("resource/editApplication");
        try {
            //获取记录
            ApplicationVO resultVo = applicationServiceImpl.get(vo);
            mav.addObject("vo", resultVo);
        } catch (Exception e) {
            log.error("更新数据异常", e);
        }
        return mav;
    }

    /**
     * 查询列表页
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public JsonResult list(HttpServletRequest request) {
        JsonResult result = new JsonResult();
        try {
            //获取登录用户信息
            UserInfo userInfo = redisCacheSessionServiceImpl.readSession(request.getSession().getId(), securityConfig.getSecuritKey());
            List<ApplicationVO> data = new ArrayList<ApplicationVO>();
            if (userInfo.isAdministrator()) {
                data = applicationServiceImpl.queryAll();
            } else {
                ApplicationVO application = new ApplicationVO();
                application.setStart(0);
                application.setLimit(Integer.MAX_VALUE);
                application.setUserId(userInfo.getUserId());
                data = applicationServiceImpl.query(application);
            }
            // 设置结果集
            result.put("list", data);
            result.put("rowCount", data.size());
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("查询异常", e);
            result.setMessage("查询异常");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/add")
    public ModelAndView addApplication() {
        ModelAndView modelAndView = new ModelAndView("/resource/addApplication");
        return modelAndView;
    }

    /**
     * 新增记录
     *
     * @param application
     * @return
     */
    @RequestMapping(value = "/post")
    @ResponseBody
    public JsonResult post(ApplicationVO application) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //保存
            applicationServiceImpl.insert(application);
            result.setSuccess(true);
            result.setMessage("成功!");
            result.put("backUrl", "/umplatform/resource/index");
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
     * @param application
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult delete(ApplicationVO application) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //删除记录
            applicationServiceImpl.delete(application);
            result.setMessage("成功!");
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("删除数据异常", e);
            result.setMessage("删除数据异常");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping(value = "/edit")
    public ModelAndView edit(ApplicationVO application) {
        ModelAndView mav = new ModelAndView("/resource/editApplication");
        JsonResult result = new JsonResult();
        try {
            //获取记录
            ApplicationVO vo = applicationServiceImpl.get(application);
            mav.addObject("application", vo);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return mav;
    }

    /**
     * 更新记录
     *
     * @param application
     * @return
     */
    @RequestMapping(value = "/put")
    @ResponseBody
    public JsonResult put(ApplicationVO application) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            applicationServiceImpl.update(application);
            result.setSuccess(true);
            result.put("backUrl", "/umplatform/resource/index");
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 记录详情
     *
     * @param application
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public JsonResult get(ApplicationVO application) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //获取记录
            result.setData(applicationServiceImpl.get(application));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
