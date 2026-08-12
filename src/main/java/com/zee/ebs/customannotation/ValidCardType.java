package com.zee.ebs.customannotation;


import com.zee.ebs.customannotation.validator.CardTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */


@Documented
@Constraint(validatedBy = CardTypeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCardType {
    String message() default "Invalid cardType";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

