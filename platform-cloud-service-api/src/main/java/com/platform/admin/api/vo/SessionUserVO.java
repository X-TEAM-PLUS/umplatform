package com.platform.admin.api.vo;

import com.platform.admin.security.UserInfo;

import java.io.Serializable;

/**
 * Created by xinleisong on 2018/1/8.
 */
public class SessionUserVO implements Serializable {

    private String sessionId;

    private UserInfo userVO;

    private String desKey;

    public SessionUserVO() {

    }

    public SessionUserVO(UserInfo userInfo, String id, String desKey) {
        this.userVO = userInfo;
        this.sessionId = id;
        this.desKey = desKey;
    }


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public UserInfo getUserVO() {
        return userVO;
    }

    public void setUserVO(UserInfo userVO) {
        this.userVO = userVO;
    }

    public String getDesKey() {
        return desKey;
    }

    public void setDesKey(String desKey) {
        this.desKey = desKey;
    }
}
