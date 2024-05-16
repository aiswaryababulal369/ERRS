package com.bytes.errs.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
	public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
