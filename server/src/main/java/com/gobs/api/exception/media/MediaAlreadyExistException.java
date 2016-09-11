package com.gobs.api.exception.media;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Media with given ImdbID already exist")
public class MediaAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = -5018523544650804104L;

	public MediaAlreadyExistException(String msg) {
		super(msg);
	}
}
