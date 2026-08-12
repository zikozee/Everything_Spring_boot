package com.zee.ebs.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 14 Jul, 2026
 */

@RestControllerAdvice
public class GlobalRestHandler {

    @ExceptionHandler(FieldValidationException.class)
    ResponseEntity<AppResponse<String>> onFieldValidationException(FieldValidationException ex){

        AppResponse<String> appResponse = AppResponse.<String>builder()
                .fieldErrors(ex.getFieldErrors())
                .build();

        return new ResponseEntity<>(appResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<AppResponse<String>> onMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> new FieldError(e.getField(), e.getDefaultMessage(), e.getRejectedValue())
                ).toList();

        AppResponse<String> appResponse = AppResponse.<String>builder()
                .fieldErrors(fieldErrors)
                .build();

        return new ResponseEntity<>(appResponse, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
