package com.zee.ebs.dto;


import com.zee.ebs.customannotation.ValidCardType;
import com.zee.ebs.customannotation.ValidPhoneNumber;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

@Data
public class PaymentRequest {
    @DecimalMin(value = "100", message = "amount is required")
    private BigDecimal amount;
    @NotBlank(message = "merchantName is required")
    private String merchantName;
    @NotBlank(message = "reference is required")
    private String reference;
    @NotBlank(message = "currency is required")
    private String currency;

    @Valid
    private Contact contact;

    @ValidCardType(message = "card type is really not valid")
    private String cardType = "VERVE";

    @NotBlank(message = "payeeName is required", groups = {Verve.class})
    private String payeeName;
    @NotNull(message = "due date is required", groups = {Verve.class})
    @Future(message = "due date should be in the future", groups = {Verve.class})
    private LocalDate dueDate;

    @NotBlank(message = "requesterName is required", groups = {Visa.class})
    private String requesterName;

    @Min(value = 18, message = "payeeAge is required", groups = {MasterCard.class})
    private int payeeAge;


    @Data
    public static class Contact {
        @NotBlank(message = "address is required")
        private String address;
        @ValidPhoneNumber(message = "phoneNumber is not valid")
        @NotBlank(message = "phoneNumber is required")
        private String phoneNumber;
    }

    public interface Verve{}
    public interface MasterCard{}
    public interface Visa{}

}
