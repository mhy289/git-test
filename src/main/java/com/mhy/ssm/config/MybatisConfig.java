package com.mhy.ssm.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean getsqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);
        ssfb.setTypeAliasesPackage("com.mhy.ssm.pojo"); // 指明POJO类所在的包
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //msc.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        msc.setBasePackage("com.mhy.ssm.mapper"); // 指明Mapper接口所在的包
        return msc;
    }
}
