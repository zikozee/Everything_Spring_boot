package com.zee.ebs.dto;


import java.util.Arrays;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

public enum CardType {
    VISA, MASTERCARD, VERVE;


    public static boolean isValidCardType(String cardType){
        return Arrays.stream(CardType.values())
                .anyMatch(ct -> ct.name().equalsIgnoreCase(cardType));

    }
}
