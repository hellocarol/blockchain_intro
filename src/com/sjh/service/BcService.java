package com.sjh.service;

import java.util.List;

import com.sjh.entity.blockchain;;

public interface BcService {

	int deleteByPrimaryKey(Integer id);

	List<blockchain> getAllbcs();

	int insert(blockchain record);

	int insertSelective(blockchain record);

	blockchain selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(blockchain record);

	int updateByPrimaryKey(blockchain record);
}
