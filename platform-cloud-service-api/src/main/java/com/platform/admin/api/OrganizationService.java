package com.platform.admin.api;


import com.platform.admin.api.vo.OrganizationVO;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_ORGANIZATION表Service接口
 */
@FeignClient("platform-admin-service-provider")
public interface OrganizationService {

    /**
     * 获取
     *
     * @param organization
     * @return int
     */
    @RequestMapping(value = "/platform/organizationService/get", method = GET)
    public OrganizationVO get(final OrganizationVO organization) throws Exception;

    /**
     * 新增
     *
     * @param organization
     * @return int
     */
    @RequestMapping(value = "/platform/organizationService/insert", method = GET)
    public int insert(final OrganizationVO organization) throws Exception;

    /**
     * 删除
     *
     * @param organization
     * @return int
     */
    @RequestMapping(value = "/platform/organizationService/delete", method = GET)
    public int delete(final OrganizationVO organization) throws Exception;

    /**
     * 更新
     *
     * @param organization
     * @return int
     */
    @RequestMapping(value = "/platform/organizationService/update", method = GET)
    public int update(final OrganizationVO organization) throws Exception;

    /**
     * 查询所有记录
     *
     * @return List<Organization>
     */
    @RequestMapping(value = "/platform/organizationService/queryAll", method = GET)
    public List<OrganizationVO> queryAll() throws Exception;

    /**
     * 查询
     *
     * @param organization
     * @return List<Organization>
     */
    @RequestMapping(value = "/platform/organizationService/query", method = GET)
    public List<OrganizationVO> query(final OrganizationVO organization) throws Exception;


    /**
     * 获取组织机构树
     *
     * @param withCheckBox
     * @return
     */
    @RequestMapping(value = "/platform/organizationService/getOrgTree", method = GET)
    List<ExtTreeNode> getOrgTree(final boolean withCheckBox);

    /**
     * 获取所有父级组织
     */
    @RequestMapping(value = "/platform/organizationService/queryParentOrgList", method = GET)
    public List<OrganizationVO> queryParentOrgList();
}
