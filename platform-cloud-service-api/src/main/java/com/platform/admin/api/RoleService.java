package com.platform.admin.api;



import com.platform.admin.api.vo.RoleVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_ROLE表Service接口
 */
@FeignClient("platform-admin-service-provider")
public interface RoleService {

    /**
     * 获取
     *
     * @param role
     * @return int
     */
    @RequestMapping(value = "/platform/roleService/get", method = GET)
    public RoleVO get(final RoleVO role) throws Exception;

    /**
     * 新增
     *
     * @param role
     * @return int
     */
    @RequestMapping(value = "/platform/roleService/insert", method = GET)
    public int insert(final RoleVO role) throws Exception;

    /**
     * 删除
     *
     * @param role
     * @return int
     */
    @RequestMapping(value = "/platform/roleService/delete", method = GET)
    public int delete(final RoleVO role) throws Exception;

    /**
     * 更新
     *
     * @param role
     * @return int
     */
    @RequestMapping(value = "/platform/roleService/update", method = GET)
    public int update(final RoleVO role) throws Exception;

    /**
     * 查询所有记录
     *
     * @return List<Role>
     */
    @RequestMapping(value = "/platform/roleService/queryAll", method = GET)
    public List<RoleVO> queryAll() throws Exception;

    /**
     * 查询
     *
     * @param role
     * @return List<Role>
     */
    @RequestMapping(value = "/platform/roleService/query", method = GET)
    public List<RoleVO> query(final RoleVO role) throws Exception;

    /**
     * 查询记录数
     *
     * @param role
     * @return List<Role>
     */
    @RequestMapping(value = "/platform/roleService/queryCount", method = GET)
    public Long queryCount(final RoleVO role) throws Exception;

}
