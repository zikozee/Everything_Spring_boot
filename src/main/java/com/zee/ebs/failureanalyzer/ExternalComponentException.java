package com.zee.ebs.failureanalyzer;


import lombok.Getter;

/**
 * @dev : Ezekiel Eromosei
 * @date : 27 Sep, 2026
 */

@Getter
public class ExternalComponentException extends RuntimeException{
    private final String url;

    public ExternalComponentException(String url) {
        this(url, null);
    }

    public ExternalComponentException(String url, Throwable cause) {
        super("URL: " + url + " is not accessible", cause);
        this.url = url;
    }
}
