package com.elk.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elk.userservice.objects.UserDetails;

@Repository
public interface UserServiceRepository extends JpaRepository<UserDetails, Integer>{
	
	
}
