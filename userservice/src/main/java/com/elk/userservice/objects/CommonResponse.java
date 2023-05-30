package com.elk.userservice.objects;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse implements Serializable{

	private String sessionId;

}
