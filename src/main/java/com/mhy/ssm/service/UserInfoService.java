package com.mhy.ssm.service;

public interface UserInfoService {
    Boolean login(String username, String password);

    Boolean changePW(String username, String password);
}
