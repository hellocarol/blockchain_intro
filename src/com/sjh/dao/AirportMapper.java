package com.sjh.dao;

import java.util.List;

import com.sjh.entity.Airport;
import com.sjh.entity.Users;

public interface AirportMapper {
	 List<Airport> getAllAirports();
	 
    int deleteByPrimaryKey(Integer id);

    int insert(Airport record);

    int insertSelective(Airport record);

    Airport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Airport record);

    int updateByPrimaryKey(Airport record);
}