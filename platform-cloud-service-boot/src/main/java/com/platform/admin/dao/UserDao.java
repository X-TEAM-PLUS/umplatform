package com.platform.admin.dao;

import java.util.List;

import com.platform.admin.domain.User;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_USER表Mapper接口
 */

public interface UserDao {

    /**
     * 获取
     *
     * @param user
     * @return User
     */
    public User get(User user);

    /**
     * 新增
     *
     * @param user
     * @return int
     */
    public int insert(User user);

    /**
     * 删除
     *
     * @param user
     * @return int
     */
    public int delete(User user);

    /**
     * 更新
     *
     * @param user
     * @return int
     */
    public int update(User user);


    /**
     * 查询所有记录
     *
     * @return List<User>
     */
    public List<User> queryAll();

    /**
     * 查询
     *
     * @param user
     * @return List<User>
     */
    public List<User> query(User user);

    /**
     * 查询
     *
     * @param user
     * @return List<User>
     */
    public Long queryCount(User user);

    /**
     * 锁定用户
     * @param user
     */
    public void lock(User user);
}
