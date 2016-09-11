package com.gobs.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Invalid numbers in query")
public class IntegerParseException extends RuntimeException {

	private static final long serialVersionUID = 2897550654503224831L;

	public IntegerParseException(String msg)
	{
		super(msg);
	}
}
