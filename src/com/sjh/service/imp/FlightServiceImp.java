package com.sjh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sjh.dao.FlightMapper;
import com.sjh.entity.Flight;
import com.sjh.service.FlightService;

@Service

public class FlightServiceImp implements FlightService {
	@Resource
	FlightMapper flightMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return flightMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return flightMapper.getAllFlight();
	}

	@Override
	public int insert(Flight record) {
		// TODO Auto-generated method stub
		return flightMapper.insert(record);
	}

	@Override
	public int insertSelective(Flight record) {
		// TODO Auto-generated method stub
		return flightMapper.insertSelective(record);
	}

	@Override
	public Flight selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return flightMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Flight record) {
		// TODO Auto-generated method stub
		return flightMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Flight record) {
		// TODO Auto-generated method stub
		return flightMapper.updateByPrimaryKey(record);
	}

}
