package com.mhy.ssm.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface LogService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void save(String from, String to, Double money, Boolean flag);
}
