package com.platform.admin.service.impl;

import com.platform.admin.api.vo.OrganizationVO;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import com.platform.admin.dao.OrganizationDao;
import com.platform.admin.domain.Organization;
import com.platform.admin.service.convert.OrganizationConvert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_ORGANIZATION表Service接口实现类
 */

@RestController
@RequestMapping("/platform/organizationService")
public class OrganizationServiceImpl extends AbstractServiceProvider {
    private final static Log log = LogFactory.getLog(OrganizationServiceImpl.class);

    private OrganizationConvert myOrganizationConvertService = new OrganizationConvert();

    @javax.annotation.Resource
    private OrganizationDao organizationDao;


    @RequestMapping("/get")
    public OrganizationVO get(@RequestBody OrganizationVO organization) throws Exception {
        Organization po = organizationDao.get(myOrganizationConvertService.toPO(organization));
        return myOrganizationConvertService.toVO(po);
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/insert")
    public int insert(@RequestBody OrganizationVO organization) throws Exception {
        organization.setCreated(new Date());
        organization.setUpdated(new Date());
        return organizationDao.insert(myOrganizationConvertService.toPO(organization));
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/delete")
    public int delete(@RequestBody OrganizationVO organization) throws Exception {
        Organization org = new Organization();
        org.setParentId(organization.getId());
        List<Organization> organizations = organizationDao.query(org);
        if (organizations != null && organizationDao.query(org).size() > 0) {
            throw new Exception("还拥有子节点菜单，不能删除!");
        }
        return organizationDao.delete(myOrganizationConvertService.toPO(organization));
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/update")
    public int update(@RequestBody OrganizationVO organization) throws Exception {
        organization.setUpdated(new Date());
        return organizationDao.update(myOrganizationConvertService.toPO(organization));
    }


    @RequestMapping("/queryAll")
    public List<OrganizationVO> queryAll() throws Exception {
        List<OrganizationVO> returnValue = new ArrayList<OrganizationVO>();
        List<Organization> organizationList = organizationDao.queryAll();
        for (Organization temp : organizationList) {
            returnValue.add(myOrganizationConvertService.toVO(temp));
        }
        return returnValue;
    }


    @RequestMapping("/query")
    public List<OrganizationVO> query(@RequestBody OrganizationVO organization) throws Exception {
        List<OrganizationVO> returnValue = new ArrayList<OrganizationVO>();
        List<Organization> organizationList = organizationDao.query(myOrganizationConvertService.toPO(organization));
        for (Organization temp : organizationList) {
            Organization orgCondition = new Organization();
            orgCondition.setId(temp.getParentId());
            Organization parent = organizationDao.get(orgCondition);
            OrganizationVO parentVO = myOrganizationConvertService.toVO(parent);
            OrganizationVO vo = myOrganizationConvertService.toVO(temp);
            vo.setParentVO(parentVO);
            returnValue.add(vo);
        }
        return returnValue;
    }


    @RequestMapping("/queryParentOrgList")
    public List<OrganizationVO> queryParentOrgList() {
        List<OrganizationVO> returnValue = new ArrayList<OrganizationVO>();
        List<Organization> organizationList = organizationDao.queryParentOrgList();
        for (Organization temp : organizationList) {
            Organization orgCondition = new Organization();
            orgCondition.setId(temp.getParentId());
            Organization parent = organizationDao.get(orgCondition);
            OrganizationVO parentVO = myOrganizationConvertService.toVO(parent);
            OrganizationVO vo = myOrganizationConvertService.toVO(temp);
            vo.setParentVO(parentVO);
            returnValue.add(vo);
        }
        return returnValue;
    }


    @RequestMapping("/getOrgTree")
    public List<ExtTreeNode> getOrgTree(@RequestBody boolean withCheckBox) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();

        try {
            //查询资源记录
            List<OrganizationVO> organizations = queryAll();
            //将所有信息按树形结构拼装成树节点
            Map<String, String> usedMap = new HashMap<String, String>();
            for (OrganizationVO organization : organizations) {
                //避免重复
                if (usedMap.get(organization.getId()) == null) {
                    ExtTreeNode node = fromOrganization(organizations, usedMap, organization, withCheckBox);
                    nodes.add(node);
                }
            }
        } catch (Exception e) {
            log.error("获取菜单树异常", e);
        }

        //返回
        return nodes;
    }


    /**
     * 递归获取子节点
     *
     * @param list   所有节点
     * @param nodeId 当前节点id
     * @return
     */
    private List<ExtTreeNode> getChilds(List<OrganizationVO> list, Map<String, String> usedMap, String nodeId, boolean withCheckBox) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();

        for (OrganizationVO dto : list) {
            if (usedMap.get(dto.getId()) == null   //不重复
                    && (nodeId.equalsIgnoreCase(dto.getParentId())   //如果父节点相等
                    || (dto.getParentId() == null) //如果父节点为空，appId相同
            )) {
                ExtTreeNode node = fromOrganization(list, usedMap, dto, withCheckBox);
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
     * @param withCheckBox
     * @return
     */
    private ExtTreeNode fromOrganization(List<OrganizationVO> list, Map<String, String> usedMap, OrganizationVO dto, boolean withCheckBox) {
        //做标识，避免重复遍历
        usedMap.put(dto.getId(), "");
        ExtTreeNode node = new ExtTreeNode();
        //节点ID
        node.setId(dto.getId());
        //名称
        node.setText(dto.getName());
        node.setCode(dto.getCode());
        //父节点id
        node.setParentId(dto.getParentId());
        //设置子节点
        node.setChildren(getChilds(list, usedMap, node.getId(), withCheckBox));
        //是否为叶子节点
        if (node.getChildren() != null && node.getChildren().size() > 0) {
            node.setLeaf(false);
            //node.setUrl(null);
        } else {
            node.setLeaf(true);
            node.setChildren(null);
        }
        //是否有复选框
        if (withCheckBox) {
            node.setChecked(false);
        }

        //other信息
        node.setCreated(dto.getCreated());
        node.setUpdated(dto.getUpdated());
        node.setOperator(dto.getOperator());
        node.setRemark(dto.getRemark());
        return node;
    }
}
