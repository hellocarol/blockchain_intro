package com.sjh.dao;

import java.util.List;
import com.sjh.entity.blockchain;

public interface blockchainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(blockchain record);

    int insertSelective(blockchain record);

    blockchain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(blockchain record);

    int updateByPrimaryKey(blockchain record);
    
    List<blockchain> getAllbcs();
}