package com.sjh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sjh.dao.UsersMapper;
import com.sjh.entity.Users;
import com.sjh.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Resource
	UsersMapper usersMapper;
	
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersMapper.getAllUsers();
	}
	
	@Override
	public int insert(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return usersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKey(record);
	}

	@Override
	public Users selectByUsernamePwd(String username, String password) {
		// TODO Auto-generated method stub
		return usersMapper.selectByUsernamePwd(username,password);
	}

}
