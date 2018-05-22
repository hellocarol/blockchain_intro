package com.sjh.dao;

import java.util.List;

import com.sjh.entity.Flight;

public interface FlightMapper {
	
	List<Flight> getAllFlight();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Flight record);

    int insertSelective(Flight record);

    Flight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Flight record);

    int updateByPrimaryKey(Flight record);
}