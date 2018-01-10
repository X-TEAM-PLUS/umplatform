package com.platform.admin.dao;

import java.util.List;

import com.platform.admin.domain.Organization;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_ORGANIZATION表Mapper接口
 */

public interface OrganizationDao {

    /**
     * 获取
     *
     * @param organization
     * @return Organization
     */
    public Organization get(Organization organization);

    /**
     * 新增
     *
     * @param organization
     * @return int
     */
    public int insert(Organization organization);

    /**
     * 删除
     *
     * @param organization
     * @return int
     */
    public int delete(Organization organization);

    /**
     * 更新
     *
     * @param organization
     * @return int
     */
    public int update(Organization organization);


    /**
     * 查询所有记录
     *
     * @return List<Organization>
     */
    public List<Organization> queryAll();

    /**
     * 查询
     *
     * @param organization
     * @return List<Organization>
     */
    public List<Organization> query(Organization organization);

    /**
     * 查询
     *
     * @param organization
     * @return List<Organization>
     */
    public Integer queryCount(Organization organization);

    /**
     * 查询所有父级组织单位
     * @return
     */
    public List<Organization> queryParentOrgList();
}
