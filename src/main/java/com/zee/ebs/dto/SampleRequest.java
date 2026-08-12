package com.zee.ebs.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @dev : Ezekiel Eromosei
 * @date : 27 Jul, 2026
 */

public record SampleRequest(
        @Size(min = 5, max = 100, message = "Full name must be between 5 and 100 characters")
        @NotBlank(message = "full name cannot be empty")
        String fullName,
        @Min(value = 18, message = "you must be at least 18")
        @Max(value = 50, message = "you must not be older than 50")
        int age,

        @Past(message = "date of birth must be present or in the past")
        LocalDate dob,

        @DecimalMax(value = "10000", message = "max 10000")
        @DecimalMin(value = "100", message = "min 100")
        BigDecimal amount,

        @Valid
        Metadata metadata

) {
}
