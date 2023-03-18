package org.jpdr.application.handler;

import org.jpdr.application.exception.RequestValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestValidationException.class)
    public ResponseStatusException handleRequestValidationException(final RequestValidationException requestValidationException) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, requestValidationException.getMessage());
    }
}
