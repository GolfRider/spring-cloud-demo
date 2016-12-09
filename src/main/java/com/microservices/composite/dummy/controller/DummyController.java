package com.microservices.composite.dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.composite.dummy.service.DummyService;
import com.microservices.core.user.User;

@RestController
public class DummyController {
	
	@Autowired
	DummyService dummyService;
	
	@RequestMapping("/dummy")
	public User getDummyUser(){
		return dummyService.getDummyUser();
				
	}
	

}
