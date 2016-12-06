package com.microservices.composite.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.microservices.utils.CommonUtils;

@SpringBootApplication 
@EnableDiscoveryClient
public class DashboardServer {

	public static void main(String args[]){
		 System.setProperty("spring.config.name", "dashboard-service");
		 System.getProperties().put( "server.port", CommonUtils.getFreePort() );
		 SpringApplication.run(DashboardServer.class, args);
		
	}
}

