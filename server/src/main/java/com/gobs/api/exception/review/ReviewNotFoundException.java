package com.gobs.api.exception.review;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Review not found")
public class ReviewNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4065631185843022078L;
	
	public ReviewNotFoundException(String msg)
	{
		super(msg);
	}
}
