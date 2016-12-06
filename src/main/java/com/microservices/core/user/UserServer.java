package com.microservices.core.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.microservices.utils.CommonUtils;

@SpringBootApplication 
@EnableDiscoveryClient
public class UserServer {
	
	public static void main(String args[]){
		 System.setProperty("spring.config.name", "user-service");
		 System.getProperties().put( "server.port", CommonUtils.getFreePort() );
		 SpringApplication.run(UserServer.class, args);
	}
}
