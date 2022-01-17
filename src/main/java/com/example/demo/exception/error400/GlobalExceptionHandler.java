package com.example.demo.exception.error400;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Alan.Juan
 *
 */

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String handleExceptionHandler(HttpMessageNotReadableException e) {
        return "格式錯誤";
    }
}