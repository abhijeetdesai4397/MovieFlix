package com.gobs.api.exception.media;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Media does not exist")
public class MediaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6402540155385040046L;

	public MediaNotFoundException(String msg) {
		super(msg);
	}
}
