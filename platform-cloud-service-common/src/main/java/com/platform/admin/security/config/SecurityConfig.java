package com.platform.admin.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xinleisong on 2018/1/6.
 */
@Component
public class SecurityConfig {
    @Value("${security.des.key}")
    public String securitKey;

    @Value("${security.authenticate.url}")
    public String loginUrl;

    public String getSecuritKey() {
        return securitKey;
    }

    public void setSecuritKey(String securitKey) {
        this.securitKey = securitKey;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}

