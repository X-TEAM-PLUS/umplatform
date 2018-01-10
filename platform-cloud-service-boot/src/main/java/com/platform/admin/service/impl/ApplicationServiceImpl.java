package com.platform.admin.service.impl;

import com.platform.admin.api.vo.ApplicationVO;
import com.platform.admin.dao.ApplicationDao;
import com.platform.admin.dao.ResourceDao;
import com.platform.admin.domain.Application;
import com.platform.admin.domain.Resource;
import com.platform.admin.service.convert.ApplicationConvert;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:50
 * 功能:T_MANAGE_APPLICATION表Service接口实现类
 */

@RestController
@RequestMapping("/platform/applicationService")
public class ApplicationServiceImpl extends AbstractServiceProvider {

    ApplicationConvert myApplicationConvert = new ApplicationConvert();
    @javax.annotation.Resource
    private ResourceDao resourceDao;

    @javax.annotation.Resource
    private ApplicationDao applicationDao;

    @RequestMapping("/get")
    public ApplicationVO get(@RequestBody ApplicationVO application) throws Exception {
        Application returnValue = applicationDao.get(myApplicationConvert.toPO(application));
        return myApplicationConvert.toVO(returnValue);
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/insert")
    public int insert(@RequestBody ApplicationVO application) throws Exception {
        application.setCreated(new Date());
        application.setUpdated(new Date());
        return applicationDao.insert(myApplicationConvert.toPO(application));
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/delete")
    public int delete(@RequestBody ApplicationVO application) throws Exception {
        Resource resource = new Resource();
        resource.setAppId(application.getId());
        if (resourceDao.query(resource).size() > 0) {
            throw new Exception("还拥有子节点菜单，不能删除!");
        }
        return applicationDao.delete(myApplicationConvert.toPO(application));
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/update")
    public int update(@RequestBody ApplicationVO application) throws Exception {
        application.setUpdated(new Date());
        return applicationDao.update(myApplicationConvert.toPO(application));
    }

    @RequestMapping("/queryAll")
    public List<ApplicationVO> queryAll() throws Exception {
        List returnValue = new ArrayList();
        List<Application> applicationList = applicationDao.queryAll();
        for (Application application : applicationList) {
            application.setIcon(application.getIcon());
            returnValue.add(myApplicationConvert.toVO(application));
        }
        return returnValue;
    }

    @RequestMapping("/query")
    public List<ApplicationVO> query(@RequestBody ApplicationVO application) throws Exception {
        List returnValue = new ArrayList();
        List<Application> applicationList = applicationDao.query(myApplicationConvert.toPO(application));
        for (Application app : applicationList) {
            app.setIcon(app.getIcon());
            returnValue.add(myApplicationConvert.toVO(app));
        }
        return returnValue;
    }
}
