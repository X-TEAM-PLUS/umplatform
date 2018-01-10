package com.platform.admin.service.cache;


import com.platform.admin.api.vo.SessionUserVO;
import com.platform.admin.common.json.JsonUtils;
import com.platform.admin.common.security.DesUtils;
import com.platform.admin.security.UserInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by xinleisong on 2017/11/30.
 */
@RestController
@RequestMapping("/platform/redisSessionService")
public class RedisCacheSessionServiceImpl {

    private final String RAND_CODE = "RAND_CODE";

    private final String BACKURL = "BACKURL";

    private final int TIMEOUT = 1000 * 60 * 60;

    @Resource
    private RedisTemplate redisTemplate;


    @RequestMapping("/writeSession")
    public void writeSession(@RequestBody SessionUserVO sessionUserVO) {
        String userInfoJson = JsonUtils.toJSON(sessionUserVO.getUserVO());
//        String value = DesUtils.encrypt(desKey, userInfoJson);
        redisTemplate.opsForValue().set(getSessionKey(sessionUserVO.getSessionId(), sessionUserVO.getDesKey()), userInfoJson);
        redisTemplate.expire(getSessionKey(sessionUserVO.getSessionId(), sessionUserVO.getDesKey()), TIMEOUT, TimeUnit.MILLISECONDS);
    }


    @RequestMapping("/readSession")
    public UserInfo readSession(@RequestParam(value = "sessionId", required = true) String sessionId,
                                @RequestParam(value = "desKey", required = true) String key) {
        System.out.println("读取用户sesion 数据 key [" + getSessionKey(sessionId, key) + "]");
        String userInfoJson = (String) redisTemplate.opsForValue().get(getSessionKey(sessionId, key));
        if (StringUtils.isEmpty(userInfoJson)) {
            return null;
        }
        return JsonUtils.fromJSON(userInfoJson, UserInfo.class);
    }


    @RequestMapping("/writeBackUrl")
    public void writeBackUrl(@RequestParam String sessionId, @RequestParam String backUrl, @RequestParam String desKey) {
        redisTemplate.opsForValue().set(sessionId + BACKURL, backUrl);
        redisTemplate.expire(sessionId + BACKURL, TIMEOUT, TimeUnit.MILLISECONDS);
    }


    @RequestMapping("/readBackUrl")
    public String readBackUrl(@RequestParam String sessionId, @RequestParam String desKey) {
        String temp = (String) redisTemplate.opsForValue().get(sessionId + BACKURL);
        if (StringUtils.isEmpty(temp)) {
            return null;
        }
        return temp;
    }


    @RequestMapping("/writeRandCode")
    public void writeRandCode(@RequestParam String sessionId, @RequestParam String randCode, @RequestParam String desKey) {

        redisTemplate.opsForValue().set(sessionId + RAND_CODE, randCode);
        redisTemplate.expire(sessionId + RAND_CODE, TIMEOUT, TimeUnit.MILLISECONDS);
    }


    @RequestMapping("/readRandCode")
    public String readRandCode(@RequestParam String sessionId, @RequestParam String desKey) {
        String temp = (String) redisTemplate.opsForValue().get(sessionId + RAND_CODE);
        if (StringUtils.isEmpty(temp)) {
            return null;
        }
        return temp;
    }


    @RequestMapping("/deleteBackUrl")
    public void deleteBackUrl(@RequestParam String sessionId, @RequestParam String desKey) {
        redisTemplate.delete(sessionId + BACKURL);
    }


    @RequestMapping("/deleteRanCode")
    public void deleteRanCode(@RequestParam String sessionId, @RequestParam String desKey) {
        redisTemplate.delete(sessionId + RAND_CODE);

    }


    @RequestMapping("/deleteSession")
    public void deleteSession(@RequestParam String sessionId, @RequestParam String desKey) {
        redisTemplate.delete(getSessionKey(sessionId, desKey));
    }

    private String getSessionKey(String sessionId, String desKey) {
        return DesUtils.encrypt(desKey, sessionId);
    }
}
