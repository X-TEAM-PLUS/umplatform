package com.platform.admin.dao;

import com.platform.admin.domain.Resource;

import java.util.List;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_RESOURCE表Mapper接口
 */

public interface ResourceDao {

    /**
     * 获取
     *
     * @param resource
     * @return Resource
     */
    public Resource get(Resource resource);

    /**
     * 新增
     *
     * @param resource
     * @return int
     */
    public int insert(Resource resource);

    /**
     * 删除
     *
     * @param resource
     * @return int
     */
    public int delete(Resource resource);

    /**
     * 更新
     *
     * @param resource
     * @return int
     */
    public int update(Resource resource);


    /**
     * 查询所有记录
     *
     * @return List<Resource>
     */
    public List<Resource> queryAll();

    /**
     * 查询
     *
     * @param resource
     * @return List<Resource>
     */
    public List<Resource> query(Resource resource);

    /**
     * 查询 where 不带分页
     * @param resource
     * @return
     */
    public List<Resource> queryNoPage(Resource resource);


    /**
     * 查询
     *
     * @param resource
     * @return List<Resource>
     */
    public Integer queryCount(Resource resource);
}
