package com.elk.userservice.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elk.userservice.controller.UserController;
import com.elk.userservice.objects.UserDetails;
import com.elk.userservice.objects.UserRequest;
import com.elk.userservice.objects.UserResponse;
import com.elk.userservice.repository.UserServiceRepository;

import lombok.Setter;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserServiceRepository userRepository;
	
	Logger logger = LogManager.getLogger(UserController.class);	


	public UserResponse getUser(UserRequest userReq) {
		
		String methodName = "getUser()";

		UserResponse response = new UserResponse();
		UserDetails userDetails =  new UserDetails();

		try {
			if(userReq == null || userReq.getId() == null) {			
				response.setStatusCode("00006");
				response.setStatusMessage("userId cannot be empty");
				logger.info("UserId validation failed");
				return response;
			}
			
			logger.info(methodName +":: UserId validation success");

			Optional<UserDetails> userDetailsOpt  = userRepository.findById(userReq.getId());
			if(userDetailsOpt.isPresent()) {

				logger.info("User available for userId : ?", userReq.getId());
				userDetails = userDetailsOpt.get();
				UserRequest user = getUserFromUserDetails(userDetails);

				response.setUserData(user);
				response.setStatusCode("00000");
				response.setStatusMessage("Success");

			}else {
				logger.info(methodName +":: User not found for userId : ?", userReq.getId());
				response.setStatusCode("00006");
				response.setStatusMessage("No user found!");
			}
			
		}catch(Exception e) {
			logger.error("Exception occurred in getUser: ?",e.getMessage() );
			e.printStackTrace();
		}finally {
			response.setSessionId(userReq.getSessionId());
		}
		return response;
	}


	public UserResponse addUser(UserRequest user) {

		String methodName = "adduser()";
		
		UserResponse response = new UserResponse();
		UserDetails userDetails =  new UserDetails();

		try {
			if(user == null) {			
				response.setStatusCode("00006");
				response.setStatusMessage("New user data not passed.");
				logger.info("User obj validation failed");
				return response;
			}
			logger.info(methodName+ ":: User obj validation success");
			userDetails.setFirstname(user.getFirstname());
			userDetails.setLastname(user.getLastname());
			userDetails.setEmail(user.getEmail());
			userDetails.setPhone(user.getPhone());
			userDetails.setCountry(user.getCountry());

			UserDetails savedUserDetail = userRepository.save(userDetails);
			logger.info(methodName+":: User data saved");

			UserRequest savedUser = getUserFromUserDetails(savedUserDetail);

			response.setUserData(savedUser);
			response.setStatusCode("00000");
			response.setStatusMessage("Success");
			
		}catch(Exception e) {

			logger.error("Exception occurred in addUser: ?",e.getMessage() );
			e.printStackTrace();
		
		}finally {
			response.setSessionId(user.getSessionId());
		}

		return response;
	}


	private UserRequest getUserFromUserDetails(UserDetails userDetails) {

		UserRequest user = new UserRequest();

		user.setId(userDetails.getId());
		user.setFirstname(userDetails.getFirstname());
		user.setLastname(userDetails.getLastname());
		user.setEmail(userDetails.getEmail());
		user.setPhone(userDetails.getPhone());
		user.setCountry(userDetails.getCountry());

		return user;
	}
}
