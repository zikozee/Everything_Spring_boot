package com.zee.ebs.controllers.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 14 Jul, 2026
 */

@RestControllerAdvice
public class GlobalRestHandler {

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
