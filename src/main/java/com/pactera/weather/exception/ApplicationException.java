package com.pactera.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Application Error.") 
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1290441413607317174L;

	public ApplicationException(String msg, Throwable e) {
		super(msg, e);
	}

	public ApplicationException(Throwable e) {
		super(e);
	}

	public ApplicationException(String msg) {
		super(msg);
	}
}
