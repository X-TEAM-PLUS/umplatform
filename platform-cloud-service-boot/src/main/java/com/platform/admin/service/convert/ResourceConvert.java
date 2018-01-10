package com.platform.admin.service.convert;

import com.platform.admin.api.vo.ResourceVO;
import com.platform.admin.domain.Resource;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class ResourceConvert implements ConvertCommon<ResourceVO, Resource> {
    @Override
    public ResourceVO toVO(Resource resource) {
        if(resource==null)
            return null;
        ResourceVO vo = new ResourceVO();
        BeanUtils.copyProperties(resource, vo);
        return vo;
    }

    @Override
    public Resource toPO(ResourceVO resourceVO) {
        if(resourceVO==null)
            return null;
        Resource po = new Resource();
        BeanUtils.copyProperties(resourceVO, po);
        return po;
    }
}
