package com.blog.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User savedUser(User user) {
		User userExists = userRepository.findByUsername(user.getUsername());
		
		if(userExists == null) {
			return userRepository.save(user);
		}else {
			return null;
		}
	}
	
	public User validateUser(User user) {
		User userExists = userRepository.findByUsername(user.getUsername());
		
		if(userExists != null) {
			if(Objects.equals(userExists.getPassword(), user.getPassword()))
				return userExists;
			else
				return null;
		}else
			return null;
	}
	
	public User updateUser(User user) {
		User userExists = userRepository.findByUsername(user.getUsername());
		
		if(userExists != null) {
			if(!Objects.equals(user.getPassword(), "")) {
				userExists.setPassword(user.getPassword());
			}else {
				userExists.setPassword(userExists.getPassword());
			}
			
			if(!Objects.equals(user.getName(), "")){
				userExists.setName(user.getName());
	        }else{
	            userExists.setName(userExists.getName());
	        }
			
			return userRepository.save(userExists);
		}else {
			return null;
		}
	}
	
	public Long getSize(){
	   return userRepository.count();
	}
}
