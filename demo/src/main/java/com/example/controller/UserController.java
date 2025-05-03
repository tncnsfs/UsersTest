package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUser() {
    	List<User> users = userService.findAllUser();
    	return users;
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
    	
    	User user = userService.findById(id);
//    	System.out.println("controller user : " + user);
        return user;
    }
    
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
    	userService.insertUser(user);
    	
    	return ResponseEntity.status(201).body("데이터가 정상적으로 입력되었습니다." + user.toString());
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user){
    	
    	User users = userService.findById(id);
    	if (users != null) {
			users.setAge(user.getAge());
			users.setContent(user.getContent());
			userService.updateUser(users);
			return ResponseEntity.status(201).body("데이터가 정상적으로 수정되었습니다."+ users.toString());
		}
    	
    	return ResponseEntity.status(201).body("데이터가 수정 되지 않았습니다."+ users.getId());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
    	
    	if (userService.findById(id) != null) {
    		userService.deleteUser(id);
    		return ResponseEntity.status(201).body(id + ": 데이터가 정상적으로 삭제되었습니다." );
		}
    	
    	return ResponseEntity.status(201).body(id + ": 데이터가 정상적으로 삭제되지 않았습니다." );
    }
    
    
	

}
