package com.bytes.errs.exception;

public class InvalidCredentialsException extends RuntimeException {
	public InvalidCredentialsException(String message) {
        super(message);
    }
}
