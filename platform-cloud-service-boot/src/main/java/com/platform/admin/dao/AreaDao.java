package com.platform.admin.dao;

import java.util.List;

import com.platform.admin.domain.Area;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * 功能:T_MANAGE_AREA表Mapper接口
 */

public interface AreaDao {

    /**
     * 获取
     *
     * @param area
     * @return Area
     */
    public Area get(Area area);

    /**
     * 新增
     *
     * @param area
     * @return int
     */
    public int insert(Area area);

    /**
     * 删除
     *
     * @param area
     * @return int
     */
    public int delete(Area area);

    /**
     * 更新
     *
     * @param area
     * @return int
     */
    public int update(Area area);


    /**
     * 查询所有记录
     *
     * @return List<Area>
     */
    public List<Area> queryAll();

    /**
     * 查询
     *
     * @param area
     * @return List<Area>
     */
    public List<Area> query(Area area);

    /**
     * 查询
     *
     * @param area
     * @return List<Area>
     */
    public Integer queryCount(Area area);
}
