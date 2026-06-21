package com.zee.ebs.healthindicator;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 21 Jun, 2026
 */

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoffeeHotDto {
    private String title;
    private String description;
    private List<String> ingredients;
    private String image;
    private Integer id;
}
