package com.platform.admin.dao;

import java.util.List;

import com.platform.admin.domain.RoleResource;
import org.apache.ibatis.annotations.Param;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_ROLE_POPEDOM表Mapper接口
 */

public interface RoleResourceDao {

    /**
     * 获取
     *
     * @param roleResource
     * @return RoleResource
     */
    public RoleResource get(RoleResource roleResource);

    /**
     * 新增
     *
     * @param roleResource
     * @return int
     */
    public int insert(RoleResource roleResource);

    /**
     * 删除
     *
     * @param roleResource
     * @return int
     */
    public int delete(RoleResource roleResource);

    /**
     * 更新
     *
     * @param roleResource
     * @return int
     */
    public int update(RoleResource roleResource);


    /**
     * 查询所有记录
     *
     * @return List<RoleResource>
     */
    public List<RoleResource> queryAll();

    /**
     * 查询
     *
     * @param roleResource
     * @return List<RoleResource>
     */
    public List<RoleResource> query(RoleResource roleResource);


    /**
     * 查询
     *
     * @param roleResource
     * @return List<RoleResource>
     */
    public Integer queryCount(RoleResource roleResource);

    /**
     * 根据角色ID查询
     * @param roleId
     */
    public List<RoleResource> queryWithRoleId(@Param("roleId") String roleId);

    /**
     * 根据角色ID删除记录
     * @param roleId
     */
    public void deleteWithRoleId(@Param("roleId") String roleId);

    /**
     * 根据resourceId删除记录
     * @param resourceId
     */
    void deleteWithResourceId(String resourceId);
}
