package com.platform.admin.webapp.controller;

import com.platform.admin.api.OrganizationService;
import com.platform.admin.api.vo.OrganizationVO;
import com.platform.admin.common.result.JsonResult;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import com.platform.admin.common.util.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_ORGANIZATION表控制器
 */

@Controller
@RequestMapping("/umplatform/organization")
public class OrganizationController {
    private static final Log log = LogFactory.getLog(OrganizationController.class);

    @javax.annotation.Resource
    private OrganizationService organizationServiceImpl;

    @RequestMapping(value = "/index")
    public String index() {
        return "/organization/index";
    }


    /**
     * 查询列表页
     *
     * @param organization
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public JsonResult list(OrganizationVO organization) {
        JsonResult result = new JsonResult();
        try {
            if (organization != null&& organization.getName() != null&& !"".equalsIgnoreCase(organization.getName())) {
                //organization.setName(new String(organization.getName().getBytes("ISO-8859-1"), "UTF-8"));
            }
            List<OrganizationVO> data = organizationServiceImpl.query(organization);
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

    @RequestMapping(value="/add")
    public ModelAndView  add(OrganizationVO organizationVO){
        ModelAndView modelAndView = new ModelAndView("/organization/add");
        try {
            if(organizationVO!=null && organizationVO.getParentId()!=null){
                modelAndView.addObject("parentId",organizationVO.getParentId());
                modelAndView.addObject("organizationLable","部门");
            }else{
                modelAndView.addObject("organizationLable","公司");
            }
        } catch (Exception e) {
            log.error("准备添加数据时异常", e);

        }
        return modelAndView;
    }


    /**
     * 新增记录
     *
     * @param organization
     * @return
     */
    @RequestMapping(value = "/post")
    @ResponseBody
    public JsonResult post(OrganizationVO organization) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //保存
            organizationServiceImpl.insert(organization);
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
     * @param organization
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult delete(OrganizationVO organization) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //删除记录
            organizationServiceImpl.delete(organization);
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("删除数据异常", e);
            result.setMessage("删除数据异常");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping(value="/edit")
    public ModelAndView toEdit(OrganizationVO organizationVO){
        ModelAndView modelAndView = new ModelAndView("organization/edit");
        try {
            //获取记录
            OrganizationVO organization = organizationServiceImpl.get(organizationVO);
            modelAndView.addObject("organization", organization);
            if(organization!=null && organization.getParentId()!=null){
                modelAndView.addObject("organizationLable","部门");
            }else{
                modelAndView.addObject("organizationLable","公司");
            }

        } catch (Exception e) {
            log.error("获取数据异常", e);
        }
        return modelAndView;
    }

    /**
     * 更新记录
     *
     * @param organization
     * @return
     */
    @RequestMapping(value = "/put")
    @ResponseBody
    public JsonResult put(OrganizationVO organization) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            organizationServiceImpl.update(organization);
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
     * @param organization
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public JsonResult get(OrganizationVO organization) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //获取记录
            result.setData(organizationServiceImpl.get(organization));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @RequestMapping("/getOrgTree")
    @ResponseBody
    public List<ExtTreeNode> getOrgTree() {
        return organizationServiceImpl.getOrgTree(false);
    }
    @RequestMapping(value="/checkNameIsUsed")
    @ResponseBody
    public JsonResult  checkNameIsUsed(OrganizationVO organizationVO){
        JsonResult result =new JsonResult();
        String id=organizationVO.getId();
        organizationVO.setId("");
        try {
            List<OrganizationVO>organizationVOs=organizationServiceImpl.query(organizationVO);
            if (organizationVOs!=null&&organizationVOs.size()>0){
                if (id!=null&&!id.equals("")){
                    if (id.equals(organizationVOs.get(0).getId())||id==organizationVOs.get(0).getId()){
                        result.setSuccess(true);
                    }else{
                        result.setSuccess(false);
                        result.setMessage("组织名称已经被使用");
                    }
                }else{
                    result.setSuccess(false);
                    result.setMessage("组织名称已经被使用");
                }
            }else{
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }
    @RequestMapping(value="/checkCodeIsUsed")
    @ResponseBody
    public JsonResult  checkCodeIsUsed(OrganizationVO organizationVO){
        JsonResult result =new JsonResult();
        String id=organizationVO.getId();
        organizationVO.setId("");
        try {
            List<OrganizationVO>organizationVOs=organizationServiceImpl.query(organizationVO);
            if (organizationVOs!=null&&organizationVOs.size()>0){
                if (id!=null&&!id.equals("")){
                    if (id.equals(organizationVOs.get(0).getId())||id==organizationVOs.get(0).getId()){
                        result.setSuccess(true);
                    }else{
                        result.setSuccess(false);
                        result.setMessage("组织名称已经被使用");
                    }
                }else{
                    result.setSuccess(false);
                    result.setMessage("组织名称已经被使用");
                }
            }else{
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return result;
    }

}
