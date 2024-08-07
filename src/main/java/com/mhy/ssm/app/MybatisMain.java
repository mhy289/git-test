package com.mhy.ssm.app;

import com.mhy.ssm.config.SpringConfig;
import com.mhy.ssm.pojo.Account;
import com.mhy.ssm.pojo.TblAccount;
import com.mhy.ssm.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MybatisMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ac.getBean(AccountService.class);
        List<TblAccount> accountList = accountService.findAll();
        for (TblAccount account : accountList) {
            System.out.println(account);
        }
    }
}
