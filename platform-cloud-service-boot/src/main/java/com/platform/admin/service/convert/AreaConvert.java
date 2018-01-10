package com.platform.admin.service.convert;

import com.platform.admin.api.vo.AreaVO;
import com.platform.admin.domain.Area;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class AreaConvert implements ConvertCommon<AreaVO,Area>{
    @Override
    public AreaVO toVO(Area area) {
        if(area==null)
            return null;
        AreaVO vo = new AreaVO();
        BeanUtils.copyProperties(area, vo);
        return vo;
    }

    @Override
    public Area toPO(AreaVO areaVO) {
        if(areaVO==null)
            return null;
        Area po = new Area();
        BeanUtils.copyProperties(areaVO, po);
        return po;
    }
}
