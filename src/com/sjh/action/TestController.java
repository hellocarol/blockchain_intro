package com.sjh.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/datatable")
	public String datatable(){
		
		return "WEB-INF/datatable";
	}
	@RequestMapping("/pictable")
	public String pictable(){
		return "WEB-INF/pictable";
	}
	@RequestMapping("/addedit")
	public String addedit(){
		return "WEB-INF/addedit";
	}
}
