package com.elk.userservice.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userdetails")
@Getter
@Setter
public class UserDetails {

	@Id
	@GeneratedValue
	private Integer id;
	private String firstname;
	private String lastname;	
	private String email;
	private String phone;
	private String country;

}
