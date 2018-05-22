package com.sjh.service;

import java.util.List;

import com.sjh.entity.Users;

public interface UserService {
	 List<Users> getAllUsers();
	 int insert(Users record);
	 int deleteByPrimaryKey(Integer id);
	 int updateByPrimaryKeySelective(Users record);
	 int updateByPrimaryKey(Users record);
	 Users selectByUsernamePwd(String username,String password);
}
