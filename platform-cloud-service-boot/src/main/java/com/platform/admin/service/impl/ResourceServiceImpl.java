package com.platform.admin.service.impl;

import com.platform.admin.api.ResourceType;
import com.platform.admin.api.vo.ApplicationVO;
import com.platform.admin.api.vo.ResourceVO;
import com.platform.admin.api.vo.RoleResourceVO;
import com.platform.admin.api.vo.TreeInfoVO;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import com.platform.admin.api.vo.tree.TreeNode;
import com.platform.admin.dao.ApplicationDao;
import com.platform.admin.dao.ResourceDao;
import com.platform.admin.dao.RoleResourceDao;
import com.platform.admin.domain.Application;
import com.platform.admin.domain.Resource;
import com.platform.admin.domain.RoleResource;
import com.platform.admin.service.convert.ApplicationConvert;
import com.platform.admin.service.convert.ResourceConvert;
import com.platform.admin.service.convert.RoleResourceConvert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_RESOURCE表Service接口实现类
 */

@RestController
@RequestMapping("/platform/resourceService")
public class ResourceServiceImpl extends AbstractServiceProvider {
    private final static Log log = LogFactory.getLog(ResourceServiceImpl.class);

    private ResourceConvert myResourceConvertService = new ResourceConvert();

    private RoleResourceConvert myRoleResourceConvertService = new RoleResourceConvert();

    private ApplicationConvert myApplicationConvert = new ApplicationConvert();
    @javax.annotation.Resource
    private ResourceDao resourceDao;

    @javax.annotation.Resource
    private ApplicationDao applicationDao;

    @javax.annotation.Resource
    private RoleResourceDao roleResourceDao;


    @RequestMapping("/get")
    public ResourceVO get(@RequestBody ResourceVO resource) throws Exception {
        Resource po = resourceDao.get(myResourceConvertService.toPO(resource));
        return myResourceConvertService.toVO(po);
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/insert")
    public int insert(@RequestBody ResourceVO resource) throws Exception {
        int result = 0;
        if (null == resource.getAppId() || "".equalsIgnoreCase(resource.getAppId())) {
            resource.setAppId(resourceDao.get(new Resource(resource.getParentId())).getAppId());
        }
        resource.setCreated(new Date());
        resource.setUpdated(new Date());
        result = resourceDao.insert(myResourceConvertService.toPO(resource));

        if (!StringUtils.isEmpty(resource.getRoles())) {
            String[] roles = resource.getRoles().split(",");
            for (String roleId : roles) {
                RoleResourceVO roleResource = new RoleResourceVO();
                roleResource.setCreated(new Date());
                roleResource.setUpdated(new Date());
                roleResource.setRoleId(roleId);
                roleResource.setResourceId(resource.getId());
                roleResourceDao.insert(myRoleResourceConvertService.toPO(roleResource));
            }
        }
        return result;
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/delete")
    public int delete(@RequestBody ResourceVO resourceVO) throws Exception {
        Resource resource = new Resource();
        resource.setParentId(resourceVO.getId());
        if (resourceDao.query(resource).size() > 0) {
            throw new Exception("还拥有子节点菜单，不能删除!");
        }
        roleResourceDao.deleteWithResourceId(resourceVO.getId());
        return resourceDao.delete(myResourceConvertService.toPO(resourceVO));
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/update")
    public int update(@RequestBody ResourceVO resource) throws Exception {
        Resource oldData = resourceDao.get(myResourceConvertService.toPO(resource));
        oldData.setName(resource.getName());
        oldData.setUrl(resource.getUrl());
        oldData.setIcon(resource.getIcon());
        oldData.setResourceType(resource.getResourceType());
        oldData.setUpdated(new Date());
        oldData.setRemark(resource.getRemark());
        return resourceDao.update(oldData);
    }


    @RequestMapping("/queryAll")
    public List<ResourceVO> queryAll() throws Exception {
        List<ResourceVO> returnValue = new ArrayList();
        List<Resource> resourceList = resourceDao.queryAll();
        for (Resource temp : resourceList)
            returnValue.add(myResourceConvertService.toVO(temp));
        return returnValue;
    }


    @RequestMapping("/query")
    public List<ResourceVO> query(@RequestBody ResourceVO resource) throws Exception {
        List<ResourceVO> returnValue = new ArrayList();
        List<Resource> resourceDtoList = resourceDao.query(myResourceConvertService.toPO(resource));
        for (Resource temp : resourceDtoList)
            returnValue.add(myResourceConvertService.toVO(temp));
        return returnValue;
    }


    @RequestMapping("/getTreeWithRoleId")
    public List<ExtTreeNode> getTreeWithRoleId(@RequestBody TreeInfoVO treeInfoVO) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();
        try {
            List<ResourceVO> list = new ArrayList<ResourceVO>();
            Map<String, String> resourceCheckedMap = new HashMap<String, String>();

            List<RoleResource> roleResourceList = roleResourceDao.queryWithRoleId(treeInfoVO.getRoleId());
            for (RoleResource roleResource : roleResourceList) {
                resourceCheckedMap.put(roleResource.getResourceId(), roleResource.getResourceId());
            }

            //查询应用
            List<Application> applicationList = applicationDao.queryAll();
            //转换成资源信息列表
            List<ResourceVO> appList = convert(applicationList);
            list.addAll(appList);
            //查询资源记录
            ResourceVO res = new ResourceVO();
            if (treeInfoVO.getResourceType() != 4)
                res.setResourceType(String.valueOf(treeInfoVO.getResourceType()));
            List<Resource> resourceDtoList = resourceDao.query(myResourceConvertService.toPO(res));
            //合并模块和资源
            for (Resource temp : resourceDtoList)
                list.add(myResourceConvertService.toVO(temp));
            //将所有信息按树形结构拼装成树节点
            Map<String, String> usedMap = new HashMap<String, String>();
            for (ResourceVO resource : list) {
                //避免重复
                if (usedMap.get(resource.getId()) == null) {
                    ExtTreeNode node = fromResourceDto(list, usedMap, resource, resourceCheckedMap, treeInfoVO.isUsedCheckBox());
                    nodes.add(node);
                }
            }
        } catch (Exception e) {
            log.error("获取菜单树异常", e);
        }

        //设置 图标路径
        setContextPathPath(nodes, treeInfoVO.getContextPath());

        //返回
        return nodes;
    }


    @RequestMapping("/getTree")
    public List<ExtTreeNode> getTree(@RequestBody TreeInfoVO treeInfoVO) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();

        try {
            //角色权限关联信息
            Map<String, String> resourceCheckedMap = new HashMap<String, String>();
            List<ResourceVO> list = new ArrayList<ResourceVO>();
            //如果没有指定模块ID
            if (StringUtils.isEmpty(treeInfoVO.getAppId())) {
                //查询资源记录
                Resource resource = new Resource();
                if (!treeInfoVO.isAdministrator()) {
                    resource.setUserId(treeInfoVO.getUserId());
                }
                if (treeInfoVO.getResourceType() != 4)
                    resource.setResourceType(String.valueOf(treeInfoVO.getResourceType()));
                List<Resource> resourceDtoList = resourceDao.query(resource);

                //查询应用
                List<Application> applicationList = applicationDao.queryAll();
                Map<String, ApplicationVO> applicationMap = new HashMap<String, ApplicationVO>();
                for (Application application : applicationList) {
                    applicationMap.put(application.getId(), myApplicationConvert.toVO(application));
                }

                //设置资源的URL
                for (Resource res : resourceDtoList) {
                    if (!StringUtils.isEmpty(applicationMap.get(res.getAppId()).getUrl()) && !StringUtils.isEmpty(res.getUrl())) {
                        res.setUrl(applicationMap.get(res.getAppId()).getUrl() + "/" + res.getUrl());
                    }
                }

                //转换成资源信息列表
                List<ResourceVO> appList = convert(applicationList);
                list.addAll(appList);

                //合并模块和资源
                for (Resource temp : resourceDtoList)
                    list.add(myResourceConvertService.toVO(temp));
            } else {

                //查询应用信息
                Application app = new Application();
                app.setId(treeInfoVO.getAppId());
                Application application = applicationDao.get(app);
                //查询资源记录
                ResourceVO resource = new ResourceVO();
                resource.setAppId(treeInfoVO.getAppId());
                if (!treeInfoVO.isAdministrator()) {
                    resource.setUserId(treeInfoVO.getUserId());
                }
                if (treeInfoVO.getResourceType() != 4)
                    resource.setResourceType(String.valueOf(treeInfoVO.getResourceType()));
                List<Resource> resourceDtoList = resourceDao.query(myResourceConvertService.toPO(resource));


                //设置资源的URL
                for (Resource res : resourceDtoList) {
                    if (!StringUtils.isEmpty(application.getUrl()) && !StringUtils.isEmpty(res.getUrl()) && !res.getUrl().startsWith("http://")) {
                        res.setUrl(application.getUrl() + "/" + res.getUrl());
                    }
                }
                for (Resource temp : resourceDtoList)
                    list.add(myResourceConvertService.toVO(temp));
            }

            //将所有信息按树形结构拼装成树节点
            Map<String, String> usedMap = new HashMap<String, String>();
            for (ResourceVO resource : list) {
                //避免重复
                if (usedMap.get(resource.getId()) == null) {
                    ExtTreeNode node = fromResourceDto(list, usedMap, resource, resourceCheckedMap, false);
                    nodes.add(node);
                }
            }
        } catch (Exception e) {
            log.error("获取菜单树异常", e);
        }

        //设置 图标路径
        setContextPathPath(nodes, treeInfoVO.getContextPath());

        //返回
        return nodes;
    }

    /**
     * 设置 图标路径
     *
     * @param list
     * @param contextPath
     */
    private void setContextPathPath(List<ExtTreeNode> list, String contextPath) {
        for (TreeNode node : list) {
            node.setIcon(contextPath + node.getIcon());
            if (node.getChildren() != null && node.getChildren().size() > 0) {
                setContextPathPath(node.getChildren(), contextPath);
            }
        }

    }

    /**
     * 递归获取子节点
     *
     * @param list   所有节点
     * @param nodeId 当前节点id
     * @return
     */
    private List<ExtTreeNode> getChilds(List<ResourceVO> list, Map<String, String> usedMap, String nodeId, Map<String, String> resourceCheckedMap, boolean isUsedCheckBox) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();

        for (ResourceVO dto : list) {
            if (usedMap.get(dto.getId()) == null   //不重复
                    && (nodeId.equalsIgnoreCase(dto.getParentId())   //如果父节点相等
                    || ((dto.getParentId() == null || "".equalsIgnoreCase(dto.getParentId()))
                    && nodeId.equalsIgnoreCase(dto.getAppId())) //如果父节点为空，appId相同
            )) {
                ExtTreeNode node = fromResourceDto(list, usedMap, dto, resourceCheckedMap, isUsedCheckBox);
                nodes.add(node);
            }
        }

        return nodes;
    }

    /**
     * 将 ResourceEntity 转成  ExtTreeNode
     *
     * @param list
     * @param usedMap
     * @param dto
     * @param isUsedCheckBox
     * @return
     */
    private ExtTreeNode fromResourceDto(List<ResourceVO> list, Map<String, String> usedMap, ResourceVO dto, Map<String, String> resourceCheckedMap, boolean isUsedCheckBox) {
        //做标识，避免重复遍历
        usedMap.put(dto.getId(), "");
        ExtTreeNode node = new ExtTreeNode();
        //节点ID
        node.setId(dto.getId());
        //名称
        node.setText(dto.getName());
        //图标
        node.setIcon(dto.getIcon());
        //链接地址
        node.setUrl(dto.getUrl());
        //父节点id
        node.setParentId((dto.getParentId() == null || "".equalsIgnoreCase(dto.getParentId())) ? dto.getAppId() : dto.getParentId());
        //设置子节点
        node.setChildren(getChilds(list, usedMap, node.getId(), resourceCheckedMap, isUsedCheckBox));
        //是否为叶子节点
        if (node.getChildren() != null && node.getChildren().size() > 0) {
            node.setLeaf(false);
        } else {
            node.setLeaf(true);
            node.setChildren(null);
        }
        //是否有复选框
        if (isUsedCheckBox) {
            if (resourceCheckedMap.get(dto.getId()) != null) {
                node.setChecked(true);
            } else {
                node.setChecked(false);
            }
        }

        //other信息
        node.setAppId(dto.getAppId());
        node.setCanModify(dto.getIsCanModify());
        node.setCreated(dto.getCreated());
        node.setUpdated(dto.getUpdated());
        node.setOperator(dto.getOperator());
        node.setRemark(dto.getRemark());
        node.setType(ResourceType.form(dto.getResourceType()).getTypeName());
        return node;
    }

    /**
     * 转换信息
     *
     * @param applicationList
     * @return
     */
    private List<ResourceVO> convert(List<Application> applicationList) {
        List<ResourceVO> list = new ArrayList<ResourceVO>();
        if (applicationList != null) {
            for (Application application : applicationList) {
                ResourceVO resource = new ResourceVO();
                resource.setId(application.getId());
                resource.setAppId(application.getId());
                resource.setName(application.getName());
                resource.setUrl(application.getUrl());
                resource.setIcon(application.getIcon());
                resource.setResourceType(ResourceType.Application.getType());
                resource.setCreated(application.getCreated());
                resource.setUpdated(application.getUpdated());
                resource.setOperator(application.getOperator());
                resource.setRemark(application.getRemark());
                list.add(resource);
            }
        }
        return list;
    }
}
