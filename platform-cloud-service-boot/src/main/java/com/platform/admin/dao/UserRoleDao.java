package com.platform.admin.dao;

import java.util.List;

import com.platform.admin.domain.UserRole;
import org.apache.ibatis.annotations.Param;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_USER_ROLE表Mapper接口
 */

public interface UserRoleDao {

    /**
     * 获取
     *
     * @param userRole
     * @return UserRole
     */
    public UserRole get(UserRole userRole);

    /**
     * 新增
     *
     * @param userRole
     * @return int
     */
    public int insert(UserRole userRole);

    /**
     * 删除
     *
     * @param userRole
     * @return int
     */
    public int delete(UserRole userRole);

    /**
     * 更新
     *
     * @param userRole
     * @return int
     */
    public int update(UserRole userRole);


    /**
     * 查询所有记录
     *
     * @return List<UserRole>
     */
    public List<UserRole> queryAll();

    /**
     * 查询
     *
     * @param userRole
     * @return List<UserRole>
     */
    public List<UserRole> query(UserRole userRole);

    /**
     * 查询
     *
     * @param userRole
     * @return List<UserRole>
     */
    public Integer queryCount(UserRole userRole);

    /**
     *
     * @param userId
     */
    void deleteWithUserId(@Param("userId") String userId);

}
