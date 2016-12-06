package com.microservices.composite.dashboard;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.core.account.Account;
import com.microservices.core.user.User;

@RestController
@Import(DashboardConfig.class)
public class DashboardController {

	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@RequestMapping("/details/{userNumber}")
	public Map<String, Object> getUserInfo(@PathVariable Integer userNumber){
		String accountServiceUrl="http://ACCOUNT-SERVICE/account/{userNumber}";
		String userServiceUrl="http://USER-SERVICE/user/{userNumber}";
		logger.info("Calling core services");
		
		User userServiceResponse = restTemplate.getForObject(userServiceUrl, User.class, userNumber);
		Account accountServiceResponse = restTemplate.getForObject(accountServiceUrl, Account.class, userNumber);
		Map<String,Object> map = new HashMap<String,Object>();
		if(userServiceResponse.getUserId()!= -1 && accountServiceResponse.getUserId()!= -1){
			map.put("user_info",userServiceResponse);
			map.put("account_info",accountServiceResponse);
		}
		return map;
	}	
	
}
