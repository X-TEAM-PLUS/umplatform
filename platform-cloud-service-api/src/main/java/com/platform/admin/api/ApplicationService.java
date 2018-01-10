package com.platform.admin.api;


import com.platform.admin.api.vo.ApplicationVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_APPLICATION表Service接口
 */
@FeignClient("platform-admin-service-provider")
public interface ApplicationService {

    /**
     * 获取
     *
     * @param application
     * @return int
     */
    @RequestMapping(value = "/platform/applicationService/get", method = GET)
    public ApplicationVO get(final ApplicationVO application) throws Exception;

    /**
     * 新增
     *
     * @param application
     * @return int
     */
    @RequestMapping(value = "/platform/applicationService/insert", method = GET)
    public int insert(final ApplicationVO application) throws Exception;

    /**
     * 删除
     *
     * @param application
     * @return int
     */
    @RequestMapping(value = "/platform/applicationService/delete", method = GET)
    public int delete(final ApplicationVO application) throws Exception;

    /**
     * 更新
     *
     * @param application
     * @return int
     */
    @RequestMapping(value = "/platform/applicationService/update", method = GET)
    public int update(final ApplicationVO application) throws Exception;

    /**
     * 查询所有记录
     *
     * @return List<Application>
     */
    @RequestMapping(value = "/platform/applicationService/queryAll", method = GET)
    public List<ApplicationVO> queryAll() throws Exception;

    /**
     * 查询
     *
     * @param application
     * @return List<Application>
     */
    @RequestMapping(value = "/platform/applicationService/query", method = GET)
    public List<ApplicationVO> query(final ApplicationVO application) throws Exception;
}
