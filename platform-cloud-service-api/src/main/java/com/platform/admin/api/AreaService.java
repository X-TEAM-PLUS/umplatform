package com.platform.admin.api;

import com.platform.admin.api.vo.AreaVO;
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
 * 功能:T_MANAGE_AREA表Service接口
 */
@FeignClient("platform-admin-service-provider")
public interface AreaService {

    /**
     * 获取
     *
     * @param area
     * @return int
     */
    @RequestMapping(value = "/platform/areaService/get", method = GET)
    public AreaVO get(final AreaVO area) throws Exception;

    /**
     * 新增
     *
     * @param area
     * @return int
     */
    @RequestMapping(value = "/platform/areaService/insert", method = GET)
    public int insert(final AreaVO area) throws Exception;

    /**
     * 删除
     *
     * @param area
     * @return int
     */
    @RequestMapping(value = "/platform/areaService/delete", method = GET)
    public int delete(final AreaVO area) throws Exception;

    /**
     * 更新
     *
     * @param area
     * @return int
     */
    @RequestMapping(value = "/platform/areaService/update", method = GET)
    public int update(final AreaVO area) throws Exception;

    /**
     * 查询所有记录
     *
     * @return List<Area>
     */
    @RequestMapping(value = "/platform/areaService/queryAll", method = GET)
    public List<AreaVO> queryAll() throws Exception;

    /**
     * 查询
     *
     * @param area
     * @return List<Area>
     */
    @RequestMapping(value = "/platform/areaService/query", method = GET)
    public List<AreaVO> query(final AreaVO area) throws Exception;

    /**
     * 获取区域树
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/platform/areaService/geTree", method = GET)
    List<ExtTreeNode> getTree(final AreaVO area);
}
