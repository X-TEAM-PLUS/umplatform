package com.platform.admin.api;

import com.platform.admin.api.vo.SessionUserVO;
import com.platform.admin.security.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Created by xinleisong on 2017/11/30.
 */
@FeignClient("platform-admin-service-provider")
public interface SessionService {


    /**
     * session写入缓存
     *
     * @param request 请求所有参数
     */
    @RequestMapping(value = "/platform/redisSessionService/writeSession", method = GET)
    public void writeSession(@RequestBody SessionUserVO sessionUserVO);

    /**
     * 读取session
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/platform/redisSessionService/readSession", method = GET)
    public UserInfo readSession(@RequestParam("sessionId") String sessionId, @RequestParam("desKey") String desKey);

    /**
     * 放入backurl
     *
     * @param backUrl
     * @param desKey
     */
    @RequestMapping(value = "/platform/redisSessionService/writeBackUrl", method = GET)
    public void writeBackUrl(@RequestParam("sessionId") String sessionId, @RequestParam("backUrl") String backUrl, String desKey);

    /**
     * 读取backurl
     *
     * @param request
     * @param desKey
     */
    @RequestMapping(value = "/platform/redisSessionService/readBackUrl", method = GET)
    public String readBackUrl(@RequestParam("sessionId") String sessionId, @RequestParam("desKey") String desKey);

    /**
     * 放入随机码
     *
     * @param request
     * @param randCode
     * @param desKey
     */
    @RequestMapping(value = "/platform/redisSessionService/writeRandCode", method = GET)
    public void writeRandCode(@RequestParam("sessionId") String sessionId, @RequestParam("randCode") String randCode, @RequestParam("desKey") String desKey);

    /**
     * 读取随机码
     *
     * @param request
     * @param desKey
     * @return
     */
    @RequestMapping(value = "/platform/redisSessionService/readRandCode", method = GET)
    public String readRandCode(@RequestParam("sessionId") String sessionId, @RequestParam("desKey") String desKey);

    /**
     * 删除backurl
     *
     * @param request
     * @param desKey
     */
    @RequestMapping(value = "/platform/redisSessionService/deleteBackUrl", method = GET)
    public void deleteBackUrl(@RequestParam("sessionId") String sessionId, @RequestParam("desKey") String desKey);

    /**
     * 删除随机码
     *
     * @param request
     * @param desKey
     */
    @RequestMapping(value = "/platform/redisSessionService/deleteRanCode", method = GET)
    public void deleteRanCode(@RequestParam("sessionId") String sessionId, @RequestParam("desKey") String desKey);

    /**
     * 删除session
     *
     * @param request
     * @param desKey
     */
    @RequestMapping(value = "/platform/redisSessionService/deleteSession", method = GET)
    public void deleteSession(@RequestParam("sessionId") String sessionId, @RequestParam("desKey") String desKey);
}
