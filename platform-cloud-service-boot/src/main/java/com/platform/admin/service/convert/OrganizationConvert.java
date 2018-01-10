package com.platform.admin.service.convert;

import com.platform.admin.api.vo.OrganizationVO;
import com.platform.admin.domain.Organization;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class OrganizationConvert implements ConvertCommon<OrganizationVO,Organization> {
    @Override
    public OrganizationVO toVO(Organization organization) {
        if(organization==null)
            return null;
        OrganizationVO vo = new OrganizationVO();
        BeanUtils.copyProperties(organization, vo);
        return vo;
    }

    @Override
    public Organization toPO(OrganizationVO organizationVO) {
        if(organizationVO==null)
            return null;
        Organization po = new Organization();
        BeanUtils.copyProperties(organizationVO, po);
        return po;
    }
}
