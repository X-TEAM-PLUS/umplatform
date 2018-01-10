package com.platform.admin.service.convert;

import com.platform.admin.api.vo.UserVO;
import com.platform.admin.domain.User;
import org.springframework.beans.BeanUtils;

/**
 * Created by songxinlei on 2016/4/11.
 */
public class UserConvert implements ConvertCommon<UserVO, User> {

    @Override
    public UserVO toVO(User user) {
        if (user == null)
            return null;
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }

    @Override
    public User toPO(UserVO userVO) {
        if (userVO == null)
            return null;
        User po = new User();
        BeanUtils.copyProperties(userVO, po);

        return po;
    }
}
