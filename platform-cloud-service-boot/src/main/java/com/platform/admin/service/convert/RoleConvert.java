package com.platform.admin.service.convert;

import com.platform.admin.api.vo.RoleVO;
import com.platform.admin.domain.Role;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class RoleConvert implements ConvertCommon<RoleVO,Role> {
    @Override
    public RoleVO toVO(Role role) {
        if(role==null)
            return null;
        RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(role, vo);
        return vo;
    }

    @Override
    public Role toPO(RoleVO roleVO) {
        if(roleVO==null)
            return null;
        Role po = new Role();
        BeanUtils.copyProperties(roleVO, po);
        return po;
    }
}
