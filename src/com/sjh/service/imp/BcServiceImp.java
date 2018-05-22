package com.sjh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.sjh.dao.blockchainMapper;

import com.sjh.entity.blockchain;
import com.sjh.service.BcService;

@Service
public class BcServiceImp implements BcService {
@Resource
blockchainMapper bcMapper;

@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return bcMapper.deleteByPrimaryKey(id);
	}

	/*@Override
	public List<blockchain> getAllbcs() {
		// TODO Auto-generated method stub
		return bcMapper.getAllbcs();
	}*/
	@Override
	public int insert(blockchain record) {
		// TODO Auto-generated method stub
		return bcMapper.insert(record);
	}

	@Override
	public int insertSelective(blockchain record) {
		// TODO Auto-generated method stub
		return bcMapper.insertSelective(record);
	}
	@Override
	public blockchain selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return bcMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(blockchain record) {
		// TODO Auto-generated method stub
		return bcMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(blockchain record) {
		// TODO Auto-generated method stub
		return bcMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<blockchain> getAllbcs() {
		// TODO Auto-generated method stub
		return bcMapper.getAllbcs();
	}

}
