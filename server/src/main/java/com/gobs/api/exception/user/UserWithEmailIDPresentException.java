package com.gobs.api.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="User with gievn ID already present")
public class UserWithEmailIDPresentException extends RuntimeException {
	
	private static final long serialVersionUID = 3927151345662270127L;

	public UserWithEmailIDPresentException(String msg) {
		super(msg);
	}

}
