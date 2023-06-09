package com.elk.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
