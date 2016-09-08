package com.gobs.api.exception.address;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Address ID provided does not exist or is empty")
public class InvalidAddressIDException extends RuntimeException {

	private static final long serialVersionUID = 8733888314359297056L;
	
	public InvalidAddressIDException(String msg) {
		super(msg);
	}

}
