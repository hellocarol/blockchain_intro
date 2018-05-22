package com.sjh.service;


import com.sjh.entity.Airport;
import java.util.List;

public interface AirportService {
	
	int deleteByPrimaryKey(Integer id);

	List<Airport> getAllAirports();

	int insert(Airport record);

	int insertSelective(Airport record);

	Airport selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Airport record);

	int updateByPrimaryKey(Airport record);
}
