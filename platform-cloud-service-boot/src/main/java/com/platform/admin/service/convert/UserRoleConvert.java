package com.platform.admin.service.convert;

import com.platform.admin.api.vo.UserRoleVO;
import com.platform.admin.domain.UserRole;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class UserRoleConvert implements ConvertCommon<UserRoleVO,UserRole> {
    @Override
    public UserRoleVO toVO(UserRole userRole) {
        if(userRole==null)
            return null;
        UserRoleVO vo = new UserRoleVO();
        BeanUtils.copyProperties(userRole, vo);
        return vo;
    }

    @Override
    public UserRole toPO(UserRoleVO userRoleVO) {
        if(userRoleVO==null)
            return null;
        UserRole po = new UserRole();
        BeanUtils.copyProperties(userRoleVO, po);
        return po;
    }
}
