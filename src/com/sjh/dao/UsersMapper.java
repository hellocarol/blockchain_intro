package com.sjh.dao;

import java.util.List;

import com.sjh.entity.Users;

public interface UsersMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);
    
    Users selectByUsernamePwd(String username,String password);
    
    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    List<Users> getAllUsers();
}