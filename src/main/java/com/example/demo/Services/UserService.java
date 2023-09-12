package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Models.Login;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public boolean isValidUser(String username, String pasword) {
		
		Login user = userRepository.findByUsername(username);
		return user !=null && user.getPassword().equals(pasword);
	}
	
	public Login create(Login details) {
		return userRepository.save(details);
	}
	
	public Login update(Login details) {
		return userRepository.save(details);
	}
}