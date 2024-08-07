package com.mhy.ssm.service.impl;

import com.mhy.ssm.mapper.LogMapper;
import com.mhy.ssm.pojo.AccountLog;
import com.mhy.ssm.pojo.Log;
import com.mhy.ssm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    LogMapper mapper;
    @Override
    public void save(String from, String to, Double money, Boolean flag) {
        Log log = new Log(null, "从 " + from + "给 " + to + "转账 " + money + "钱,是否成功"+flag, new Date());
        mapper.insert(log);
    }
}
