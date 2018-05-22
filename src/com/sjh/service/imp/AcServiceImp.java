package com.sjh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sjh.dao.AcMapper;
import com.sjh.entity.Ac;
import com.sjh.service.AcService;
@Service
public class AcServiceImp implements AcService {
@Resource
AcMapper acMapper;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return acMapper.deleteByPrimaryKey(id);
	}
	
	public List<Ac> getAllacs() {
		// TODO Auto-generated method stub
		return acMapper.getAllacs();
	}
	@Override
	public int insert(Ac record) {
		// TODO Auto-generated method stub
		return acMapper.insert(record);
	}

	@Override
	public int insertSelective(Ac record) {
		// TODO Auto-generated method stub
		return acMapper.insertSelective(record);
	}

	@Override
	public Ac selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return acMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Ac record) {
		// TODO Auto-generated method stub
		return acMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Ac record) {
		// TODO Auto-generated method stub
		return acMapper.updateByPrimaryKey(record);
	}

}
