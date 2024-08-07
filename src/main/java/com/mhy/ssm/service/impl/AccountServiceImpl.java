package com.mhy.ssm.service.impl;

import com.mhy.ssm.mapper.TblAccountMapper;
import com.mhy.ssm.pojo.Account;
import com.mhy.ssm.pojo.TblAccount;
import com.mhy.ssm.pojo.TblAccountExample;
import com.mhy.ssm.service.AccountService;
import com.mhy.ssm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    TblAccountMapper accountMapper;

    @Autowired
    LogService logService;

    TblAccountExample example = new TblAccountExample();;

    @Override
    public void save(TblAccount account) {
        accountMapper.insert(account);
    }

    @Override
    public void update(TblAccount account){
        accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public void delete(Integer id) {
        accountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TblAccount findById(Integer id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TblAccount> findAll() {
        return accountMapper.selectAll();
    }


    @Override
    public Boolean transfer (String from, String to, Double money) {
        boolean flag = true;

        try {
            TblAccount fromAcc = accountMapper.selectByNameTblAccount(from);
            TblAccount toAcc = accountMapper.selectByNameTblAccount(to);
            if(fromAcc.getMoney()>=money){
                fromAcc.setMoney(fromAcc.getMoney() - money);
                accountMapper.updateByPrimaryKeySelective(fromAcc);
                toAcc.setMoney(toAcc.getMoney() + money);
                accountMapper.updateByPrimaryKeySelective(toAcc);
            } else {
                System.out.println("Transfer false");
                flag = false;
                throw new RuntimeException("转账失败");
            }
        } finally {

            logService.save(from, to, money, flag);
        }


        return true;
    }
}