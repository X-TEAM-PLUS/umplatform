package com.platform.admin.service.convert;

import com.platform.admin.api.vo.ApplicationVO;
import com.platform.admin.domain.Application;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class ApplicationConvert implements ConvertCommon<ApplicationVO, Application> {
    @Override
    public ApplicationVO toVO(Application application) {
        if(application==null)
            return null;
        ApplicationVO vo = new ApplicationVO();
        BeanUtils.copyProperties(application, vo);
        return vo;
    }

    @Override
    public Application toPO(ApplicationVO applicationVO) {
        if(applicationVO==null)
            return null;
        Application po = new Application();
        BeanUtils.copyProperties(applicationVO, po);
        return po;
    }
}
