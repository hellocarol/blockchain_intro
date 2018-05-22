package com.sjh.service;

import java.util.List;

import com.sjh.entity.Flight;

public interface FlightService {
	
	int deleteByPrimaryKey(Integer id);

	List<Flight> getAllFlight();

	int insert(Flight record);

	int insertSelective(Flight record);

	Flight selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Flight record);

	int updateByPrimaryKey(Flight record);
}
