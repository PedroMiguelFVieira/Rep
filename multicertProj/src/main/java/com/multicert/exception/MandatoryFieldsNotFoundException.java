package com.multicert.exception;

public class MandatoryFieldsNotFoundException extends MulticertProjBussinessException{

	private static final long serialVersionUID = 1L;

	public MandatoryFieldsNotFoundException(String message) {
		super(message);
	}
}
