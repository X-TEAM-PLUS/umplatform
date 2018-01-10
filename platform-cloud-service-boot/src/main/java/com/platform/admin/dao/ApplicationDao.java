package com.platform.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.platform.admin.domain.Application;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_APPLICATION表Mapper接口
 */

public interface ApplicationDao {

    /**
     * 获取
     *
     * @param application
     * @return Application
     */
    public Application get(Application application);

    /**
     * 新增
     *
     * @param application
     * @return int
     */
    public int insert(Application application);

    /**
     * 删除
     *
     * @param application
     * @return int
     */
    public int delete(Application application);

    /**
     * 更新
     *
     * @param application
     * @return int
     */
    public int update(Application application);


    /**
     * 查询所有记录
     *
     * @return List<Application>
     */
    public List<Application> queryAll();

    /**
     * 查询
     *
     * @param application
     * @return List<Application>
     */
    public List<Application> query(Application application);

    /**
     * 查询记录数
     * @param application
     * @return List<Application>
     */
    public Integer queryCount(Application application);

    /**
     * 按角色查询授权的应用列表
     * @param roleId
     * @return
     */
    List<Application> queryAllWithRoleId(@Param("roleId") String roleId);
}
