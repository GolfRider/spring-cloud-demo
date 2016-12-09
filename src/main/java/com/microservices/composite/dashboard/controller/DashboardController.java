package com.microservices.composite.dashboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.composite.dashboard.config.DashboardConfig;
import com.microservices.composite.dashboard.service.DashboardService;
import com.microservices.core.account.Account;
import com.microservices.core.user.User;

@RestController
@Import(DashboardConfig.class)
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	@RequestMapping("/details/{userNumber}")
	public Map<String, Object> getUserInfo(@PathVariable Integer userNumber){
		Map<String,Object> map = new HashMap<String,Object>();
		User userServiceResponse = dashboardService.getUserInfo(userNumber);
		Account accountServiceResponse = dashboardService.getAccountInfo(userNumber);
		if(userServiceResponse.getUserId()!= -1 && accountServiceResponse.getUserId()!= -1){
			map.put("user_info",userServiceResponse);
			map.put("account_info",accountServiceResponse);
		}
		return map;		
	}	
	
}
