package com.example.demo.exception.error403;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Alan.Juan
 *
 */

@RestControllerAdvice
@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccessDeniedExceptionHandler {

    @ExceptionHandler({AccessDeniedException.class})
    public String handleAccessDeniedExceptionHandler(AccessDeniedException e) {
        return e.getMessage();
    }
}