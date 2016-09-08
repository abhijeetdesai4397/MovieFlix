package com.gobs.api.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="User does not exist")
public class UserNotFountException extends RuntimeException {

	private static final long serialVersionUID = 6953270305376823908L;

	public UserNotFountException(String msg)
	{
		super(msg);
	}
}
