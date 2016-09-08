package com.gobs.api.exception.address;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Addres ID missing in request")
public class AddressIDMissingException extends RuntimeException {

	private static final long serialVersionUID = -1630048144599145982L;

	public AddressIDMissingException(String msg) {
		super(msg);
	}
}
