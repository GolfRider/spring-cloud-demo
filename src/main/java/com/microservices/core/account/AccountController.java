package com.microservices.core.account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private Logger logger = Logger.getLogger(getClass().getName());
	private Map<Integer, Account> accountInfo = new ConcurrentHashMap<Integer,Account>();
	
	@PostConstruct
	private void populateAccountInfo(){
		Account account1 =  new Account(1, 200);
		Account account2 =  new Account(2, 400);
		Account account3 =  new Account(3, 500);
		Account account4 =  new Account(3, 700);
		Account account5 =  new Account(3, 900);	
		
		accountInfo.put(1, account1);
		accountInfo.put(2, account2);
		accountInfo.put(3, account3);
		accountInfo.put(4, account4);
		accountInfo.put(5, account5);
		
	}
	
	@RequestMapping("/account/{userNumber}")
	public Account getUser(@PathVariable Integer userNumber){
		logger.info("Fetching account details for user: "+userNumber);
		if(accountInfo.containsKey(userNumber)){
			return accountInfo.get(userNumber);
		}else{
			return new Account(-1,-1);
		}
	}
}
