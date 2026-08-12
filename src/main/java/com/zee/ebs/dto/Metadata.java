package com.zee.ebs.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

public record Metadata(
        @NotBlank(message = "sector is required")
        String sector,
        @NotBlank(message = "brandName is required")
        String brandName,
        @DecimalMin(value = "500000", message = "minimumNetWorth must be greater than 500000")
        BigDecimal minimumNetWorth
) {
}
