package com.sjh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.entity.Airport;
import com.sjh.service.imp.AirportServiceImp;


@Controller
@RequestMapping("/airport")
public class AirportController {
	@Resource
	AirportServiceImp airportServiceImp;
	@RequestMapping("/list")
	public String airportlist(Model model){
		List <Airport>list=airportServiceImp.getAllAirports();
		 model.addAttribute("list",list);
		 return "WEB-INF/airport/list";
	}
	@RequestMapping("/del")
	public String del(Model model,int id){
		airportServiceImp.deleteByPrimaryKey(id);
		List<Airport> list = airportServiceImp.getAllAirports();
		model.addAttribute("list", list);
		return "WEB-INF/airport/list";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Airport add(Airport airport){
		airportServiceImp.insert(airport);
		return airport;
	}
	@RequestMapping("/modify")
	@ResponseBody
	public Airport modify(Airport airport){
		airportServiceImp.updateByPrimaryKeySelective(airport);
		return airport;
	}
	@RequestMapping("/data")
	public String pictable(){
		return "WEB-INF/airport/datatable";
	}
	@RequestMapping("/addedit")
	public String addedit(){
		return "WEB-INF/addedit";
	}


	

}
