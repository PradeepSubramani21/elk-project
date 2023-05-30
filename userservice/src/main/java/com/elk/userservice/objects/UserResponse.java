package com.elk.userservice.objects;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse  implements Serializable{

	private String sessionId;
	private UserRequest userData;
	private String statusCode;
	private String statusMessage;

}
