package com.microservices.core.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	private Map<Integer, User> userInfo = new ConcurrentHashMap<Integer, User>();
	
	@PostConstruct 
	private void populateUserInfo(){  
		//Populate dummy data, string object is used for sake of simplicity
		User user1 = new User(1, "Cupertino");
		User user2 = new User(2, "Mt View");
		User user3 = new User(3, "San Jose");
		User user4 = new User(4, "Seattle");
		User user5 = new User(5, "Sunnyvale");
		
		userInfo.put(1, user1);
		userInfo.put(2, user2);
		userInfo.put(3, user3);
		userInfo.put(4, user4);
		userInfo.put(5, user5);
	}

	@RequestMapping("/user/{userNumber}")
	public User getUser(@PathVariable Integer userNumber){
		logger.info("Fetching user details: "+userNumber);
		if(userInfo.containsKey(userNumber)){
			return userInfo.get(userNumber);
		}else{
			return new User(-1,"invalid");
		}
	}
}
