package com.platform.admin.api;


import com.platform.admin.api.vo.UserVO;
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
 * 功能:T_MANAGE_USER表Service接口
 */
@FeignClient("platform-admin-service-provider")
public interface UserService {

    /**
     * 获取
     *
     * @param user
     * @return int
     */
    @RequestMapping(value = "/platform/userService/get", method = GET)
    public UserVO get(@RequestBody UserVO user) throws Exception;

    /**
     * 新增
     *
     * @param user
     * @return int
     */
    @RequestMapping(value = "/platform/userService/insert", method = GET)
    public int insert(@RequestBody UserVO user) throws Exception;

    /**
     * 删除
     *
     * @param user
     * @return int
     */
    @RequestMapping(value = "/platform/userService/delete", method = GET)
    public int delete(@RequestBody UserVO user) throws Exception;

    /**
     * 更新
     *
     * @param user
     * @return int
     */
    @RequestMapping(value = "/platform/userService/update", method = GET)
    public int update(@RequestBody UserVO user) throws Exception;

    /**
     * 查询所有记录
     *
     * @return List<User>
     */
    @RequestMapping(value = "/platform/userService/queryAll", method = GET)
    public List<UserVO> queryAll() throws Exception;

    /**
     * 查询
     *
     * @param user
     * @return List<User>
     */
    @RequestMapping(value = "/platform/userService/query", method = GET)
    public List<UserVO> query(@RequestBody UserVO user) throws Exception;

    /**
     * 查询记录数
     *
     * @param user
     * @return List<User>
     */
    @RequestMapping(value = "/platform/userService/queryCount", method = GET)
    public Long queryCount(@RequestBody UserVO user) throws Exception;

    /**
     * 锁定用户
     *
     * @param user
     */
    @RequestMapping(value = "/platform/userService/lock", method = GET)
    public void lock(@RequestBody UserVO user);
}
