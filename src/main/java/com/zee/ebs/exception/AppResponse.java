package com.zee.ebs.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 12 Aug, 2026
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse<T> {

    private T data;
    private List<FieldError> fieldErrors;
}
