package com.zee.ebs.conditionals.factory;


import lombok.Getter;

/**
 * @dev : Ezekiel Eromosei
 * @date : 08 Jun, 2026
 */

@Getter
public class ConnectionFactory {

    private String factoryName;
    public ConnectionFactory(String factoryName) {
        this.factoryName = factoryName;
    }


}
