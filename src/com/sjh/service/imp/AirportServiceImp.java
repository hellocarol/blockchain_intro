package com.sjh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sjh.dao.AirportMapper;
import com.sjh.entity.Airport;
import com.sjh.service.AirportService;

@Service
public class AirportServiceImp implements AirportService {
	@Resource
	AirportMapper airportMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return airportMapper.deleteByPrimaryKey(id);
	}

	public List<Airport> getAllAirports() {
		// TODO Auto-generated method stub
		return airportMapper.getAllAirports();
	}

	@Override
	public int insert(Airport record) {
		// TODO Auto-generated method stub
		return airportMapper.insert(record);
	}

	@Override
	public int insertSelective(Airport record) {
		// TODO Auto-generated method stub
		return airportMapper.insertSelective(record);
	}

	@Override
	public Airport selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return airportMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Airport record) {
		// TODO Auto-generated method stub
		return airportMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Airport record) {
		// TODO Auto-generated method stub
		return airportMapper.updateByPrimaryKey(record);
	}

}
