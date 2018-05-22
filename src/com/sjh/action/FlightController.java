package com.sjh.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.entity.Ac;
import com.sjh.entity.Airport;
import com.sjh.entity.Flight;
import com.sjh.service.imp.AcServiceImp;
import com.sjh.service.imp.AirportServiceImp;
import com.sjh.service.imp.FlightServiceImp;
import com.sjh.util.DateTime;

@Controller
@RequestMapping("/flight")

public class FlightController {
	
	@Resource
	FlightServiceImp FlighterviceImp;
	@Resource
	AirportServiceImp airportServiceImp;
	@Resource
	AcServiceImp acServiceImp;
	
	@RequestMapping("/list")
	public String Flightlist(Model model){
		List<Flight> list = FlighterviceImp.getAllFlight();
		List<Airport> airportlist = airportServiceImp.getAllAirports();
		List<Ac> aclist =acServiceImp.getAllacs();
		model.addAttribute("list", list);
		model.addAttribute("airportlist", airportlist);
		model.addAttribute("aclist", aclist);
		return "WEB-INF/flight/list";
	}
	
	@RequestMapping("/del")
	public String del(Model model,int id){
		FlighterviceImp.deleteByPrimaryKey(id);
		List<Flight> list = FlighterviceImp.getAllFlight();
		model.addAttribute("list", list);
		return "WEB-INF/flight/list";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Flight add(Flight flight,String ttime){
		try {
		
			flight.setFlightdate(DateTime.stringToDate(ttime,DateTime.DATE_TIME_FORMAT));
			FlighterviceImp.insert(flight);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flight;
	}
	@RequestMapping("/modify")
	@ResponseBody
	public Flight modify(Flight flight,String ttime){
		
		try {
			
			flight.setFlightdate(DateTime.stringToDate(ttime,DateTime.DATE_TIME_FORMAT));
			FlighterviceImp.updateByPrimaryKeySelective(flight);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flight;
	}
	@RequestMapping("/data")
	public String pictable(){
		return "WEB-INF/flight/datatable";
	}
	@RequestMapping("/addedit")
	public String addedit(){
		return "WEB-INF/addedit";
	}

}

