package com.elk.userservice.service;

import com.elk.userservice.objects.UserRequest;
import com.elk.userservice.objects.UserResponse;


public interface UserService {

	public UserResponse getUser(UserRequest userReq);	
	
	public UserResponse addUser(UserRequest user);
}
