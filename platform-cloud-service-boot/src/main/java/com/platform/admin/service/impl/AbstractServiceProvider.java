package com.platform.admin.service.impl;

import com.platform.admin.common.log.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;

import java.util.List;

/**
 * Created by xinleisong on 2018/1/6.
 */
public abstract class AbstractServiceProvider extends Logging {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    protected void logInstanceInfo() {
        ServiceInstance instance = serviceInstance();
        logInfo("provider service, host = " + instance.getHost()
                + ", service_id = " + instance.getServiceId());
    }

    protected ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
