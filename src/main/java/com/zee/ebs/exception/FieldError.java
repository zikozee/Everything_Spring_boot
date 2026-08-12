package com.zee.ebs.exception;


/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

public record FieldError(
        String field,
        String message,
        Object input
) {
}
