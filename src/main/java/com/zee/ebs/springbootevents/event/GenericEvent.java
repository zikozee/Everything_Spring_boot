package com.zee.ebs.springbootevents.event;


import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

public class GenericEvent extends SpringApplicationEvent {

    @Getter
    private final String username;

    public GenericEvent(SpringApplication application, String[] args, String myUsername) {
        super(application, args);
        username = myUsername;
    }

//    public String getUsername() {
//        return username;
//    }

}
