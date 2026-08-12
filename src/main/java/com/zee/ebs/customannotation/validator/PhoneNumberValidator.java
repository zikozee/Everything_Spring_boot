package com.zee.ebs.customannotation.validator;


import com.zee.ebs.customannotation.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumber != null
                && phoneNumber.startsWith("+234")
                && phoneNumber.substring(4).length()==10;

        //+2348012341234
        //phonenumerlib
    }
}
