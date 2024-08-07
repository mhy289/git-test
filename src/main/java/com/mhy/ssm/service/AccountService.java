package com.mhy.ssm.service;

import com.mhy.ssm.pojo.Account;
import com.mhy.ssm.pojo.TblAccount;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = false)
public interface AccountService {

    @Transactional
    void save(TblAccount account);

    @Transactional
    void delete(Integer id);

    @Transactional
    void update(TblAccount account);

    @Transactional(readOnly = true)
    List<TblAccount> findAll();

    TblAccount findById(Integer id);

    @Transactional(isolation = Isolation.DEFAULT)
    Boolean transfer(String from, String to, Double money);

}