package com.sjh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.entity.Users;
import com.sjh.service.imp.UserServiceImp;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	UserServiceImp userServiceImp;
	
	@RequestMapping("/list")
	public String userlist(Model model){
		List<Users> list = userServiceImp.getAllUsers();
		model.addAttribute("list", list);
		return "WEB-INF/user/list";
	}
	
	@RequestMapping("/del")
	public String del(Model model,int id){
		userServiceImp.deleteByPrimaryKey(id);
		List<Users> list = userServiceImp.getAllUsers();
		model.addAttribute("list", list);
		return "WEB-INF/user/list";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Users add(Users user){
		userServiceImp.insert(user);
		return user;
	}
	@RequestMapping("/modify")
	@ResponseBody
	public Users modify(Users user){
		userServiceImp.updateByPrimaryKeySelective(user);
		return user;
	}
	@RequestMapping("/data")
	public String pictable(){
		return "WEB-INF/user/datatable";
	}
	@RequestMapping("/addedit")
	public String addedit(){
		return "WEB-INF/addedit";
	}

}
