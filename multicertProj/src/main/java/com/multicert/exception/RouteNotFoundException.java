package com.multicert.exception;

public class RouteNotFoundException extends MulticertProjBussinessException{

	private static final long serialVersionUID = 1L;

	public RouteNotFoundException(String message) {
		super(message);
	}
}
