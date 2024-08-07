package com.mhy.ssm.mapper;

import com.mhy.ssm.pojo.TblAccount;
import com.mhy.ssm.pojo.TblAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblAccountMapper {
    long countByExample(TblAccountExample example);

    int deleteByExample(TblAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblAccount record);

    int insertSelective(TblAccount record);

    List<TblAccount> selectByExample(TblAccountExample example);

    TblAccount selectByPrimaryKey(Integer id);

    TblAccount selectByNameTblAccount(String name);

    List<TblAccount> selectAll();

    int updateByExampleSelective(@Param("record") TblAccount record, @Param("example") TblAccountExample example);

    int updateByExample(@Param("record") TblAccount record, @Param("example") TblAccountExample example);

    int updateByPrimaryKeySelective(TblAccount record);

    int updateByPrimaryKey(TblAccount record);
}