package com.microservices.core.account;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Integer userId;
	private final Integer creditPoint;
	
	public Account(@JsonProperty("userId") Integer userId, @JsonProperty("creditPoint") Integer creditPoint){
		this.userId = userId;
		this.creditPoint = creditPoint;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getCreditPoint() {
		return creditPoint;
	}
}
