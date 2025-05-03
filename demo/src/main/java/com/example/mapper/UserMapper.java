package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.User;

@Mapper
public interface UserMapper {
	
	List<User> findAllUser();
    User findById(Long id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

}
