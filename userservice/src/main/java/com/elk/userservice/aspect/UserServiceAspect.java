//package com.elk.userservice.aspect;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.context.annotation.Configuration;
//
//import com.elk.userservice.controller.UserController;
//import com.elk.userservice.objects.UserRequest;
//import com.elk.userservice.objects.UserResponse;
//import com.google.gson.Gson;
//
//@Aspect
//@Configuration
//public class UserServiceAspect {
//	
//	private Logger logger = LogManager.getLogger(UserController.class);	
//	
//	Gson gson = new Gson();
//
//	@Before("execution(* com.elk.userservice.controller.UserController.*(..))")
//	public void before(JoinPoint joinPoint){
//		logger.info("test "+joinPoint.getArgs());
//		logger.info(" Request received : {}", gson.toJson(joinPoint.getArgs(),UserRequest.class));
//	}
//	
//	@After("execution(* com.elk.userservice.controller.UserController.*(..))")
//	public void after(JoinPoint joinPoint){
//		
//		logger.info(" Response sent : "/*, gson.toJson(joinPoint.getThis())*/);
//	}
//}