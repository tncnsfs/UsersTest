package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.controller.UserController;
import com.example.mapper.UserMapper;
import com.example.model.User;

@Service
public class UserService  {
	
	private UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userMapper.findAllUser();
	}
	
	
	public User findById(Long id) {
		User user = userMapper.findById(id);
		System.out.println("user: " + user);
		return user ;
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
	}
	
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public void deleteUser(Long id) {
		userMapper.deleteUser(id);
	}



}
