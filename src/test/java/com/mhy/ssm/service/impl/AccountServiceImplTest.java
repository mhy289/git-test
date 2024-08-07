package com.mhy.ssm.service.impl;

import com.mhy.ssm.config.SpringConfig;
import com.mhy.ssm.mapper.TblAccountMapper;
import com.mhy.ssm.pojo.Account;
import com.mhy.ssm.pojo.TblAccount;
import com.mhy.ssm.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountServiceImplTest {
    @Autowired
    AccountService accountService;

    @Autowired
    TblAccountMapper accountMapper;

    @Autowired
    DataSource dataSource;

    @Test
    public void testMapper() {
        TblAccount acc = accountMapper.selectByPrimaryKey(4);
        System.out.println(acc);
        System.out.println(dataSource);
    }
    @Test
    public void testSave() {
        List<TblAccount> accounts = accountService.findAll();
        for (TblAccount account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer() {
        accountService.transfer("hhh", "asd", 10.0);
    }
}