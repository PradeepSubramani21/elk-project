package com.elk.userservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elk.userservice.objects.UserRequest;
import com.elk.userservice.objects.UserResponse;
import com.elk.userservice.service.UserServiceImpl;
import com.google.gson.Gson;

@RestController
@RequestMapping("/user-service")
public class UserController {
	
	private Logger logger = LogManager.getLogger(UserController.class);	
	
	Gson gson = new Gson();
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/get")
	public UserResponse getUser(@RequestBody UserRequest user) {		
		logger.info("Request received : "+ gson.toJson(user,UserRequest.class));
		return userService.getUser(user);
	}
	
	@PostMapping("/adduser")
	public UserResponse addUser(@RequestBody UserRequest user) {		
		logger.info("Request received : "+ gson.toJson(user,UserRequest.class));
		return userService.addUser(user);
	}


}
