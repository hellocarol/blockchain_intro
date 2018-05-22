package com.sjh.service;

import java.util.List;

import com.sjh.entity.Ac;

public interface AcService {

	int deleteByPrimaryKey(Integer id);

	List<Ac> getAllacs();

	int insert(Ac record);

	int insertSelective(Ac record);

	Ac selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Ac record);

	int updateByPrimaryKey(Ac record);
}
