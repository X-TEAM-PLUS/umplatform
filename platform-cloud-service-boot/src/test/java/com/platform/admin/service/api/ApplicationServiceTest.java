package com.platform.admin.service.api;

import com.platform.admin.ApplicationBoot;
import com.platform.admin.api.ApplicationService;
import com.platform.admin.common.json.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xinleisong on 2018/1/6.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = ApplicationBoot.class) // 指定我们SpringBoot工程的Application启动类
public class ApplicationServiceTest {

    @Resource
    private ApplicationService applicationService;

    @Test
    public void testAPI() {
        try {
            System.out.println(JsonUtils.toJSON(applicationService.queryAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
