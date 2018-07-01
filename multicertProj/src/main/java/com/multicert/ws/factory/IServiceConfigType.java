package com.multicert.ws.factory;

public enum IServiceConfigType {

	ROUTE("route"), ADDRESS("address");

	private String method;

	private IServiceConfigType(String method){
		this.method = method;
	}

	public String getMethod(){
		return this.method;
	}
}
