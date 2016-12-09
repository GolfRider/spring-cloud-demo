package com.microservices.composite.dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.microservices.utils.CommonUtils;

@EnableCircuitBreaker
@SpringBootApplication 
@EnableDiscoveryClient
public class DummyServer {

	public static void main(String args[]){
		 System.setProperty("spring.config.name", "dummy-service");
		 System.getProperties().put( "server.port", CommonUtils.getFreePort() );
		 SpringApplication.run(DummyServer.class, args);
		
	}
}

