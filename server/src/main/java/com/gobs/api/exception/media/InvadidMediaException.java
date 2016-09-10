package com.gobs.api.exception.media;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Invalid ImdbID provided")
public class InvadidMediaException extends RuntimeException {

	private static final long serialVersionUID = -3211465318453615515L;

	public InvadidMediaException(String msg) {
		super(msg);
	}
}
