package com.platform.admin.webapp.controller;

import com.platform.admin.api.RoleService;
import com.platform.admin.api.vo.RoleVO;
import com.platform.admin.common.result.JsonResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_ROLE表控制器
 */

@Controller
@RequestMapping("/umplatform/role")
public class RoleController {
    private static final Log log = LogFactory.getLog(RoleController.class);

    @javax.annotation.Resource
    private RoleService roleServiceImpl;

    @RequestMapping(value = "/index")
    public String index() {
        return "/role/index";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "/role/add";
    }

    /**
     * 查询列表页
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public JsonResult list(RoleVO role) {
        JsonResult result = new JsonResult();
        try {
            if (role != null
                    && role.getRoleName() != null
                    && !"".equalsIgnoreCase(role.getRoleName())) {
                role.setRoleName(new String(role.getRoleName().getBytes("ISO-8859-1"), "UTF-8"));
            }
            // 设置结果集
            result.put("list", roleServiceImpl.query(role));
            result.put("rowCount", roleServiceImpl.queryCount(role));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("查询异常", e);
            result.setMessage("查询异常");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping(value = "/getAll")
    @ResponseBody
    public JsonResult getAll(RoleVO role) {
        JsonResult result = new JsonResult();
        try {
            List<RoleVO> data = roleServiceImpl.queryAll();
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

    /**
     * 新增记录
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/post")
    @ResponseBody
    public JsonResult post(RoleVO role) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //保存
            roleServiceImpl.insert(role);
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
     * @param role
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult delete(RoleVO role) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //删除记录
            roleServiceImpl.delete(role);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("删除数据异常", e);
            result.setMessage("删除数据异常");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping("/edit")
    public ModelAndView edit(RoleVO roleVO) {
        ModelAndView modelAndView = new ModelAndView("role/edit");
        try {
            modelAndView.addObject("role", roleServiceImpl.get(roleVO));
        } catch (Exception e) {
            log.error("获取数据异常", e);
        }
        return modelAndView;
    }

    /**
     * 更新记录
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/put")
    @ResponseBody
    public JsonResult put(RoleVO role) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            roleServiceImpl.update(role);
            result.setSuccess(true);
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
     * @param role
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public JsonResult get(RoleVO role) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //获取记录
            result.setData(roleServiceImpl.get(role));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("获取数据异常", e);
            result.setMessage("获取数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
