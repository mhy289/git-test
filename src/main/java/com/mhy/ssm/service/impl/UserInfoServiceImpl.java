package com.mhy.ssm.service.impl;

import com.mhy.ssm.mapper.UserInfoMapper;
import com.mhy.ssm.pojo.UserInfo;
import com.mhy.ssm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper mapper;
    @Override
    public Boolean login(String username, String password) {
        UserInfo info = mapper.selectAllByUsernameUserInfo(username);
        if(info == null) {
            return false;
        }

        if(info.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean changePW(String username, String password) {
        return null;
    }
}
