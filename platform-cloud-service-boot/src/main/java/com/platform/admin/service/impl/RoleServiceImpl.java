package com.platform.admin.service.impl;

import com.platform.admin.api.vo.RoleResourceVO;
import com.platform.admin.api.vo.RoleVO;
import com.platform.admin.dao.RoleDao;
import com.platform.admin.dao.RoleResourceDao;
import com.platform.admin.domain.Role;
import com.platform.admin.domain.RoleResource;
import com.platform.admin.service.convert.RoleConvert;
import com.platform.admin.service.convert.RoleResourceConvert;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
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
 * 功能:T_MANAGE_ROLE表Service接口实现类
 */

@RestController
@RequestMapping("/platform/roleService")
public class RoleServiceImpl extends AbstractServiceProvider {

    private RoleConvert myRoleConvertService = new RoleConvert();

    private RoleResourceConvert myRoleResourceConvertService = new RoleResourceConvert();

    @javax.annotation.Resource
    private RoleDao roleDao;
    @javax.annotation.Resource
    private RoleResourceDao roleResourceDao;


    @RequestMapping("/get")
    public RoleVO get(@RequestBody RoleVO role) throws Exception {
        Role po = roleDao.get(myRoleConvertService.toPO(role));
        //查询资源
        List<RoleResource> roleResources = roleResourceDao.queryWithRoleId(role.getId());
        List<String> resourcesids = new ArrayList<String>();
        for (RoleResource roleResource : roleResources) {
            resourcesids.add(roleResource.getResourceId());
        }

        if (resourcesids.size() > 0) {
            po.setResourceIds(join(resourcesids, ","));
        }

        return myRoleConvertService.toVO(po);
    }

    /**
     * 按分隔符将数组元素分开，组成一个字符串
     *
     * @param list
     * @param separator
     * @return
     */
    private String join(List list, String separator) {
        String newString = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                newString = newString + (String) list.get(i) + separator;
            } else {
                newString = newString + (String) list.get(i);
            }
        }
        return newString;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/insert")
    public int insert(@RequestBody RoleVO roleVo) throws Exception {
        Date date = new Date();
        //保存角色记录
        roleVo.setCreated(date);
        roleVo.setUpdated(date);

        Role role = myRoleConvertService.toPO(roleVo);

        int rowCount = roleDao.insert(role);
        //保存角色权限记录
        if (!StringUtils.isEmpty(role.getResourceIds())) {
            String[] resourcesIds = role.getResourceIds().split(",");
            for (String resourceId : resourcesIds) {
                RoleResourceVO roleResource = new RoleResourceVO();
                roleResource.setCreated(date);
                roleResource.setUpdated(date);
                roleResource.setRoleId(role.getId());
                roleResource.setResourceId(resourceId);
                roleResourceDao.insert(myRoleResourceConvertService.toPO(roleResource));
            }
        }

        return rowCount;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/delete")
    public int delete(@RequestBody RoleVO role) throws Exception {
        //删除角色权限记录
        roleResourceDao.deleteWithRoleId(role.getId());
        return roleDao.delete(myRoleConvertService.toPO(role));
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/update")
    public int update(@RequestBody RoleVO roleVO) throws Exception {
        Date date = new Date();
        //删除角色权限记录
        roleResourceDao.deleteWithRoleId(roleVO.getId());

        //插入新的角色权限设置记录
        if (!StringUtils.isEmpty(roleVO.getResourceIds())) {
            String[] resourcesIds = roleVO.getResourceIds().split(",");
            for (String resourceId : resourcesIds) {
                RoleResource roleResource = new RoleResource();
                roleResource.setCreated(date);
                roleResource.setUpdated(date);
                roleResource.setRoleId(roleVO.getId());
                roleResource.setResourceId(resourceId);
                roleResourceDao.insert(roleResource);
            }
        }

        //更新角色表
        Role role = roleDao.get(myRoleConvertService.toPO(roleVO));
        //设置更新时间
        role.setUpdated(date);
        role.setRoleName(roleVO.getRoleName());
        role.setIcon(roleVO.getIcon());
        role.setRemark(roleVO.getRemark());
        return roleDao.update(role);
    }

    @RequestMapping("/queryAll")
    public List<RoleVO> queryAll() throws Exception {
        List<RoleVO> returnValue = new ArrayList<RoleVO>();
        List<Role> roleList = roleDao.queryAll();
        for (Role temp : roleList) {
            returnValue.add(myRoleConvertService.toVO(temp));
        }
        return returnValue;
    }

    @RequestMapping("/query")
    public List<RoleVO> query(@RequestBody RoleVO role) throws Exception {
        List<RoleVO> returnValue = new ArrayList<RoleVO>();
        List<Role> roleList = roleDao.query(myRoleConvertService.toPO(role));
        for (Role temp : roleList) {
            returnValue.add(myRoleConvertService.toVO(temp));
        }
        return returnValue;
    }

    @RequestMapping("/queryCount")
    public Long queryCount(@RequestBody RoleVO role) throws Exception {
        return roleDao.queryCount(myRoleConvertService.toPO(role));
    }
}
