package com.zee.ebs.failureanalyzer;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @dev : Ezekiel Eromosei
 * @date : 27 Sep, 2026
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record Post(int userId, int id, String title, String body) {
}
