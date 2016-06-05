package com.pactera.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Details Not Found") 
public class ValidationException extends Exception {

	private static final long serialVersionUID = 1290441413607317174L;

	public ValidationException(String msg, Throwable e) {
		super(msg, e);
	}

	public ValidationException(Throwable e) {
		super(e);
	}

	public ValidationException(String msg) {
		super(msg);
	}
}
