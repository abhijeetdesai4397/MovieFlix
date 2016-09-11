package com.gobs.api.exception.review;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Review rating should be between 0 and 5")
public class InvalidReviewRatingException extends RuntimeException {

	private static final long serialVersionUID = 3582765694479059107L;

	public InvalidReviewRatingException(String msg)
	{
		super(msg);
	}
}
