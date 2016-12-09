package com.microservices.support.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class HystrixDashboardAndTurbineServer {

	public static void main(String args[]){
		 System.setProperty("spring.config.name", "hystrix-dashboard");
		 SpringApplication.run(HystrixDashboardAndTurbineServer.class, args);
	}
}
