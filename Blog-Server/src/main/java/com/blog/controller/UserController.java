package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.User;
import com.blog.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	public User saveUser(@RequestBody User user) {
		return userService.savedUser(user);
	}
	
	@PostMapping("/login")
	public User validate(@RequestBody User user) {
		return userService.validateUser(user);
	}
	
	 @PostMapping("/updateUser")
	 public User updateUser(@RequestBody User user){
		 return userService.updateUser(user);
	 }
	    
	 @GetMapping("/getSize")
	 public Long getSize(){
		 return userService.getSize();
	 }
	
}
