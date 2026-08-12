package com.zee.ebs.exception;


import lombok.Getter;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

@Getter
public class FieldValidationException extends RuntimeException {

    final List<FieldError> fieldErrors;

    public FieldValidationException(List<FieldError> fieldErrors) {
        super("A field validation exception occurred");
        this.fieldErrors = fieldErrors;
    }
}
