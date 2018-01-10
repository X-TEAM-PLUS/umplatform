package com.platform.admin.api;

import com.platform.admin.api.vo.ResourceVO;
import com.platform.admin.api.vo.TreeInfoVO;
import com.platform.admin.api.vo.tree.ExtTreeNode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_RESOURCE表Service接口
 */
@FeignClient("platform-admin-service-provider")
public interface ResourceService {

    /**
     * 获取
     *
     * @param resource
     * @return int
     */
    @RequestMapping(value = "/platform/resourceService/get", method = GET)
    public ResourceVO get(final ResourceVO resource) throws Exception;

    /**
     * 新增
     *
     * @param resource
     * @return int
     */
    @RequestMapping(value = "/platform/resourceService/insert", method = GET)
    public int insert(final ResourceVO resource) throws Exception;

    /**
     * 删除
     *
     * @param resource
     * @return int
     */
    @RequestMapping(value = "/platform/resourceService/delete", method = GET)
    public int delete(final ResourceVO resource) throws Exception;

    /**
     * 更新
     *
     * @param resource
     * @return int
     */
    @RequestMapping(value = "/platform/resourceService/update", method = GET)
    public int update(final ResourceVO resource) throws Exception;

    /**
     * 查询所有记录
     *
     * @return List<Resource>
     */
    @RequestMapping(value = "/platform/resourceService/queryAll", method = GET)
    public List<ResourceVO> queryAll() throws Exception;

    /**
     * 查询
     *
     * @param resource
     * @return List<Resource>
     */
    @RequestMapping(value = "/platform/resourceService/query", method = GET)
    public List<ResourceVO> query(final ResourceVO resource) throws Exception;

    /**
     * 根据角色Id获取资源树
     *
     * @param contextPath
     * @param roleId
     * @param resourceType
     * @param isUsedCheckBox
     * @return
     */
    @RequestMapping(value = "/platform/resourceService/getTreeWithRoleId", method = GET)
    public List<ExtTreeNode> getTreeWithRoleId(@RequestBody TreeInfoVO treeInfoVO);


    /**
     * 根据用户Id、appId获取资源树
     *
     * @param contextPath
     * @param userId
     * @param resourceType
     * @param isAdministrator
     * @return
     */
    @RequestMapping(value = "/platform/resourceService/getTree", method = GET)
    public List<ExtTreeNode> getTree(@RequestBody TreeInfoVO treeInfoVO);

}
