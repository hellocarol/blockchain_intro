package com.sjh.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sjh.entity.Users;
import com.sjh.service.imp.UserServiceImp;

@Controller
public class SystemController {

	@Resource
	UserServiceImp userServiceImp;
	
	@RequestMapping("/main.do")
	public String tomain(Model model){
		
		return "WEB-INF/main";
	}
	@RequestMapping("/login.do")
	public String login(Model model,Users user,HttpSession httpsession){
		Users userReturn = userServiceImp.selectByUsernamePwd(user.getUsername(), user.getPassword());
		if (userReturn != null) {
			httpsession.setAttribute("currentUser", userReturn);
			return "WEB-INF/main";
		}
		else{
			return "WEB-INF/login";
		}
			
		
	}
	
	@RequestMapping("/left.do")
	public String left(Model model){
		
		return "WEB-INF/left";
	}
	
	@RequestMapping("/top.do")
	public String top(Model model){
		
		return "WEB-INF/top";
	}
	@RequestMapping("/right.do")
	public String right(Model model){
		
		return "WEB-INF/right";
	}
}
