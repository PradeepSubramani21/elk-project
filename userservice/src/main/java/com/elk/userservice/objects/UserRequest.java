package com.elk.userservice.objects;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UserRequest implements Serializable{
	
	private String sessionId;
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String country;


}
 