package com.platform.admin.dao;

import java.util.List;

import com.platform.admin.domain.Role;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_ROLE表Mapper接口
 */

public interface RoleDao {

    /**
     * 获取
     *
     * @param role
     * @return Role
     */
    public Role get(Role role);

    /**
     * 新增
     *
     * @param role
     * @return int
     */
    public int insert(Role role);

    /**
     * 删除
     *
     * @param role
     * @return int
     */
    public int delete(Role role);

    /**
     * 更新
     *
     * @param role
     * @return int
     */
    public int update(Role role);


    /**
     * 查询所有记录
     *
     * @return List<Role>
     */
    public List<Role> queryAll();

    /**
     * 查询
     *
     * @param role
     * @return List<Role>
     */
    public List<Role> query(Role role);

    /**
     * 查询
     *
     * @param role
     * @return List<Role>
     */
    public Long queryCount(Role role);
}
