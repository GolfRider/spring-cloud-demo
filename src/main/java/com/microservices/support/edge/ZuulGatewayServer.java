package com.microservices.support.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.microservices.utils.CommonUtils;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayServer {

	public static void main(String args[]){
			 System.setProperty("spring.config.name", "gateway-service");
			 System.getProperties().put( "server.port", CommonUtils.getFreePort() );
			 SpringApplication.run(ZuulGatewayServer.class, args);
		}
}
