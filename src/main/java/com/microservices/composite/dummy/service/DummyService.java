package com.microservices.composite.dummy.service;

import org.springframework.stereotype.Service;

import com.microservices.core.user.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DummyService {

	@HystrixCommand(fallbackMethod="getDefaultDummyUser")
	public User getDummyUser(){
		return new User(100,"dummy_location");  //Dummy Data		
	}
	
	private User getDefaultDummyUser(Throwable t){
		return new User(-1, "dummy_default_location");		
	}
	
}
