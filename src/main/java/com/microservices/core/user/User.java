package com.microservices.core.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Integer userId;
	private final String location;
	
	public User(@JsonProperty("userId") Integer userId, @JsonProperty("location") String location){
		this.userId = userId;
		this.location= location;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getLocation() {
		return location;
	}
}
