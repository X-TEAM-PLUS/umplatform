package com.platform.admin.webapp.controller;

import com.platform.admin.api.ResourceService;
import com.platform.admin.api.ResourceType;
import com.platform.admin.api.SessionService;
import com.platform.admin.api.vo.ResourceVO;
import com.platform.admin.api.vo.TreeInfoVO;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import com.platform.admin.common.result.JsonResult;
import com.platform.admin.common.security.DesUtils;
import com.platform.admin.common.util.JsonUtils;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_RESOURCE表控制器
 */

@Controller
@RequestMapping("/umplatform/resource")
public class ResourceController implements Constants {

    private static final Log log = LogFactory.getLog(ResourceController.class);

    @javax.annotation.Resource
    private SecurityConfig securityConfig;

    @javax.annotation.Resource
    private ResourceService resourceServiceImpl;

    @javax.annotation.Resource
    private SessionService sessionService;

    @RequestMapping(value = "/index")
    public String index() {
        return "/resource/index";
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public JsonResult list() {
        JsonResult result = new JsonResult();
        try {
            List<ResourceVO> list = resourceServiceImpl.queryAll();
            result.setData(list);
            result.setMessage("成功");
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("提交数据异常", e);
            result.setMessage("提交数据异常");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping(value = "/add")
    public ModelAndView add(ResourceVO resource) {
        ModelAndView modelAndView = new ModelAndView("/resource/add");
        modelAndView.addObject("appId", resource.getAppId());
        modelAndView.addObject("parentId", resource.getParentId());
        return modelAndView;
    }

    /**
     * 新增记录
     *
     * @param resource
     * @return
     */
    @RequestMapping(value = "/post")
    @ResponseBody
    public JsonResult post(ResourceVO resource) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //保存
            resourceServiceImpl.insert(resource);
            result.setMessage("成功");
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
     * @param resource
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult delete(ResourceVO resource) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //删除记录
            resourceServiceImpl.delete(resource);
            result.setMessage("删除成功!");
            result.setSuccess(true);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setMessage("删除数据异常");
            result.setSuccess(false);
        }
        return result;
    }


    @RequestMapping(value = "/edit")
    public ModelAndView edit(ResourceVO resource) {
        ModelAndView mav = new ModelAndView("/resource/edit");
        JsonResult result = new JsonResult();
        try {
            //获取记录
            ResourceVO vo = resourceServiceImpl.get(resource);
            mav.addObject("resource", vo);
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
     * @param resource
     * @return
     */
    @RequestMapping(value = "/put")
    @ResponseBody
    public JsonResult put(ResourceVO resource) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            resourceServiceImpl.update(resource);
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
     * @param resource
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public JsonResult get(ResourceVO resource) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //获取记录
            result.setData(resourceServiceImpl.get(resource));
            result.setSuccess(true);
        } catch (Exception e) {
            log.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 推送菜单
     *
     * @return
     */
    @RequestMapping("/MenuCenter")
    @ResponseBody
    public JsonResult MenuCenter(HttpServletRequest request) {
        JsonResult result = new JsonResult();
        //密钥
        String desKey = securityConfig.getSecuritKey();
        // 读取请求内容
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            //解密信息
            String menuNode = DesUtils.decrypt(desKey, sb.toString());
            //反序列化
            ExtTreeNode extTreeNode = JsonUtils.fromJSON(menuNode, ExtTreeNode.class);
            ResourceVO resource = new ResourceVO();
            switch (extTreeNode.getEvent()) {
                case LIST:
                    TreeInfoVO treeInfoVO = new TreeInfoVO();
                    treeInfoVO.setContextPath(request.getContextPath());
                    treeInfoVO.setRoleId(extTreeNode.getRoles());
                    treeInfoVO.setResourceType(Integer.parseInt(ResourceType.Menu.getType()));
                    treeInfoVO.setAdministrator(false);
                    List<ExtTreeNode> list = resourceServiceImpl.getTreeWithRoleId(treeInfoVO);
                    result.setSuccess(true);
                    result.setData(list);
                    break;
                case ADD:
                    //转换对像
                    resource.setUrl(extTreeNode.getUrl());
                    resource.setName(extTreeNode.getText());
                    resource.setIcon(extTreeNode.getIcon());
                    resource.setParentId(extTreeNode.getParentId());
                    resource.setResourceType(ResourceType.Menu.getType());
                    resource.setRoles(extTreeNode.getRoles());
                    int count = resourceServiceImpl.insert(resource);
                    if (count > 0) {
                        result.setSuccess(true);
                        result.put("menuId", resource.getId());
                    }
                    break;
                case EDIT:
                    //转换对像
                    resource.setId(extTreeNode.getId());
                    resource.setUrl(extTreeNode.getUrl());
                    resource.setName(extTreeNode.getText());
                    resource.setIcon(extTreeNode.getIcon());
                    resource.setParentId(extTreeNode.getParentId());
                    resource.setResourceType(ResourceType.Menu.getType());
                    resource.setRoles(extTreeNode.getRoles());
                    resourceServiceImpl.update(resource);
                    result.setSuccess(true);
                    break;
                case REMOVE:
                    resource.setId(extTreeNode.getId());
                    resourceServiceImpl.delete(resource);
                    result.setSuccess(true);
                    break;
            }
        } catch (Exception e) {
            log.error("添加菜单异常", e);
            result.setSuccess(false);
            result.setMessage(e.getCause().getMessage());
        }
        return result;
    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @RequestMapping("/getTree")
    @ResponseBody
    public List<ExtTreeNode> getTree(HttpServletRequest request, String appId) {
        //获取登录用户信息
        UserInfo userInfo = sessionService.readSession(request.getSession().getId(), securityConfig.getSecuritKey());
        TreeInfoVO treeInfoVO = new TreeInfoVO();
        treeInfoVO.setContextPath(request.getContextPath());
        treeInfoVO.setUserId(userInfo.getUserId());
        treeInfoVO.setAppId(appId);
        treeInfoVO.setResourceType(Integer.parseInt(ResourceType.Menu.getType()));
        treeInfoVO.setAdministrator(userInfo.isAdministrator());
        return resourceServiceImpl.getTree(treeInfoVO);
    }


    /**
     * 获取菜单树
     *
     * @return
     */
    @RequestMapping("/getResourceTree")
    @ResponseBody
    public List<ExtTreeNode> getResourceTree(HttpServletRequest request, String appId) {
        TreeInfoVO treeInfoVO = new TreeInfoVO();
        treeInfoVO.setContextPath(request.getContextPath());
        treeInfoVO.setAppId(appId);
        treeInfoVO.setResourceType(4);
        treeInfoVO.setUsedCheckBox(false);
        return resourceServiceImpl.getTree(treeInfoVO);
    }


    /**
     * 获取资源树 带checkbox
     *
     * @return
     */
    @RequestMapping("/getTreeWithRoleId")
    @ResponseBody
    public List<ExtTreeNode> getTreeWithRoleId(HttpServletRequest request, String roleId) {
        TreeInfoVO treeInfoVO = new TreeInfoVO();
        treeInfoVO.setContextPath(request.getContextPath());
        treeInfoVO.setRoleId(roleId);
        treeInfoVO.setResourceType(4);
        treeInfoVO.setUsedCheckBox(true);
        return resourceServiceImpl.getTreeWithRoleId(treeInfoVO);
    }

}
