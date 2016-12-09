package com.microservices.composite.dashboard.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.core.account.Account;
import com.microservices.core.user.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DashboardService {

	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@HystrixCommand(fallbackMethod="getDefaultUserInfo")
	public User getUserInfo(int userNumber){
		String userServiceUrl="http://USER-SERVICE/user/{userNumber}";
		return restTemplate.getForObject(userServiceUrl, User.class, userNumber);		
	}
	
	private User getDefaultUserInfo(int userNumber, Throwable t){
		return new User(-1, "default_location");		
	}
	
	@HystrixCommand(fallbackMethod="getDefaultAccountInfo")
	public Account getAccountInfo(int userNumber){
		String accountServiceUrl="http://ACCOUNT-SERVICE/account/{userNumber}";
		return restTemplate.getForObject(accountServiceUrl, Account.class, userNumber);		
	}
	
	private Account getDefaultAccountInfo(int userNumber,Throwable t){
		logger.error("fallback method called..!");
		return new Account(-1, 0); 
	}
	
	
}
