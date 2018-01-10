package com.platform.admin.service.convert;

import com.platform.admin.api.vo.RoleResourceVO;
import com.platform.admin.domain.RoleResource;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class RoleResourceConvert implements ConvertCommon<RoleResourceVO,RoleResource> {
    @Override
    public RoleResourceVO toVO(RoleResource roleResource) {
        if(roleResource==null)
            return null;
        RoleResourceVO vo = new RoleResourceVO();
        BeanUtils.copyProperties(roleResource, vo);
        return vo;
    }

    @Override
    public RoleResource toPO(RoleResourceVO roleResourceVO) {
        if(roleResourceVO==null)
            return null;
        RoleResource po = new RoleResource();
        BeanUtils.copyProperties(roleResourceVO, po);
        return po;
    }
}
