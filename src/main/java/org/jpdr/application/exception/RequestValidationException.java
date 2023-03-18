package org.jpdr.application.exception;

public class RequestValidationException extends IllegalArgumentException {
    public RequestValidationException(String message) {
        super(message);
    }
}
