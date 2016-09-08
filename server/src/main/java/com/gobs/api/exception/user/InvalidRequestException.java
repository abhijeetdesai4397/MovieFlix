package com.gobs.api.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = 8811227848016234552L;

	public InvalidRequestException(String msg)
	{
		super(msg);
	}
}
