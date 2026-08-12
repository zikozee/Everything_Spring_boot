package com.zee.ebs.customannotation.validator;


import com.zee.ebs.customannotation.ValidCardType;
import com.zee.ebs.dto.CardType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

public class CardTypeValidator implements ConstraintValidator<ValidCardType, String> {
    @Override
    public void initialize(ValidCardType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cardType, ConstraintValidatorContext context) {
        final List<String> cardTypes = List.of(CardType.VISA.name(), CardType.MASTERCARD.name(), CardType.VERVE.name());

        return cardType != null &&
                cardTypes.contains(cardType.toUpperCase());
    }
}
