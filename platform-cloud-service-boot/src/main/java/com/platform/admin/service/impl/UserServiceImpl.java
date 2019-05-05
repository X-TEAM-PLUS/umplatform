package com.platform.admin.service.impl;

import com.platform.admin.api.vo.UserRoleVO;
import com.platform.admin.api.vo.UserVO;
import com.platform.admin.dao.OrganizationDao;
import com.platform.admin.dao.UserDao;
import com.platform.admin.dao.UserRoleDao;
import com.platform.admin.domain.Organization;
import com.platform.admin.domain.User;
import com.platform.admin.domain.UserRole;
import com.platform.admin.service.convert.UserConvert;
import com.platform.admin.service.convert.UserRoleConvert;
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
 * 功能:T_MANAGE_USER表Service接口实现类
 */

@RestController
@RequestMapping("/platform/userService")
public class UserServiceImpl extends AbstractServiceProvider {

    private UserConvert myUserConvertService = new UserConvert();

    private UserRoleConvert myUserRoleConvertService = new UserRoleConvert();

    @javax.annotation.Resource
    private UserDao userDao;

    @javax.annotation.Resource
    private UserRoleDao userRoleDao;

    @javax.annotation.Resource
    private OrganizationDao organizationDao;

    
    @RequestMapping("/get")
    public UserVO get(@RequestBody UserVO userVO) throws Exception {
        User userRow = userDao.get(myUserConvertService.toPO(userVO));
        if (userRow==null){
            return null;
        }
        if (userRow != null) {
            userRow.setEnterPwd(userRow.getPassword());
            StringBuilder selectRoldes = new StringBuilder();
            UserRole ur = new UserRole();
            ur.setUserId(userRow.getId());
            List<UserRole> roles = userRoleDao.query(ur);
            boolean isStart = true;
            for (UserRole userRole : roles) {
                if (isStart) {
                    isStart = false;
                    selectRoldes.append(userRole.getRoleId());
                } else {
                    selectRoldes.append(",").append(userRole.getRoleId());
                }
                userRow.setRoles(selectRoldes.toString());
            }
        }
        if (userRow.getOrganizationId() != null) {
            Organization organization = new Organization();
            organization.setId(userRow.getOrganizationId());
            organization = organizationDao.get(organization);
            userRow.setOrganizationId(organization.getId());
            userRow.setOrganizationName(organization.getName());
        }

        return myUserConvertService.toVO(userRow);
    }


    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/insert")
    public int insert(@RequestBody UserVO userVO) throws Exception {
        User user = myUserConvertService.toPO(userVO);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setLoginCount(0);
        user.setLocked(0);
        user.setIsAdministrator(0);
        int rowCount = userDao.insert(user);

        //保存用户角色关系
        if (!StringUtils.isEmpty(user.getRoles())) {
            String[] roles = user.getRoles().split(",");
            for (String roleId : roles) {
                UserRoleVO userRole = new UserRoleVO();
                userRole.setUserId(user.getId());
                userRole.setRoleId(roleId);
                userRole.setCreated(new Date());
                userRole.setUpdated(new Date());
                userRoleDao.insert(myUserRoleConvertService.toPO(userRole));
            }
        }

        return rowCount;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/delete")
    public int delete(@RequestBody UserVO user) throws Exception {
        int count = 0;
        if (StringUtils.isEmpty(user.getIds())) {
            //删除分配的角色记录
            userRoleDao.deleteWithUserId(user.getId());
            return userDao.delete(myUserConvertService.toPO(user));
        } else {
            String[] ids = user.getIds().split(",");
            for (String id : ids) {
                //删除分配的角色记录
                userRoleDao.deleteWithUserId(id);
                count += userDao.delete(new User(id));
            }
        }
        return count;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/update")
    public int update(@RequestBody UserVO user) throws Exception {
        user.setUpdated(new Date());
        //删除旧的角色记录
        userRoleDao.deleteWithUserId(user.getId());

        //保存新设置的用户角色关系
        if (!StringUtils.isEmpty(user.getRoles())) {
            String[] roles = user.getRoles().split(",");
            for (String roleId : roles) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(user.getId());
                userRole.setRoleId(roleId);
                userRole.setCreated(new Date());
                userRole.setUpdated(new Date());
                userRoleDao.insert(userRole);
            }
        }
        user.setLoginCount(user.getLoginCount() == null ? 0 : user.getLoginCount());
        return userDao.update(myUserConvertService.toPO(user));
    }

    
    @RequestMapping("/queryAll")
    public List<UserVO> queryAll() throws Exception {
        List<UserVO> returnValue = new ArrayList<UserVO>();
        List<User> userList = userDao.queryAll();
        for (User temp : userList)
            returnValue.add(myUserConvertService.toVO(temp));
        return returnValue;
    }

    
    @RequestMapping("/query")
    public List<UserVO> query(@RequestBody UserVO user) throws Exception {
        List<UserVO> returnValue = new ArrayList<UserVO>();
        List<User> userList = userDao.query(myUserConvertService.toPO(user));
        for (User temp : userList)
            returnValue.add(myUserConvertService.toVO(temp));
        return returnValue;
    }

    
    @RequestMapping("/queryCount")
    public Long queryCount(@RequestBody UserVO user) throws Exception {
        return userDao.queryCount(myUserConvertService.toPO(user));
    }

    
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/lock")
    public void lock(@RequestBody UserVO user) {
        if (!StringUtils.isEmpty(user.getIds())) {
            String[] ids = user.getIds().split(",");
            for (String id : ids) {
                UserVO dto = new UserVO(id);
                dto.setUpdated(new Date());
                dto.setLocked(user.getLocked());
                userDao.lock(myUserConvertService.toPO(dto));
            }
        }
    }
}
