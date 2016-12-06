package com.microservices.core.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.microservices.utils.CommonUtils;

@SpringBootApplication 
@EnableDiscoveryClient
public class AccountServer {
	
	public static void main(String args[]){
		 System.setProperty("spring.config.name", "account-service");
		 System.getProperties().put( "server.port", CommonUtils.getFreePort() );
		 SpringApplication.run(AccountServer.class, args);
	}
}
