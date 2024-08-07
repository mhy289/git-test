package com.mhy.ssm.service.impl;

import com.mhy.ssm.config.SpringConfig;
import com.mhy.ssm.service.LogService;
import com.mhy.ssm.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserInfoServiceImplTest {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    LogService logService;

    @Test
    public void login(){
        Boolean flag = userInfoService.login("pig","123456 ");
        if(flag == true) {
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
