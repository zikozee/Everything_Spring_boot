package com.zee.ebs.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 14 Jul, 2026
 */

@RestController
@RequestMapping(path = "test-rest")
public class TestRestController {

    @GetMapping(path = "me")
    public String test(){
        return "test";
    }

    @GetMapping(path = "json-me")
    public Map<String, String> testJson(){
        return Map.of(
                "name", "Zee",
                "age", "62",
                "height", "185",
                "hairColor", "Black"
        );
    }

    @GetMapping(path = "json-ex/{id}")
    public ResponseEntity<Map<String, String>> jsonEx(@PathVariable int id){

        if(id == 1){
            throw new RuntimeException("yooo an exception was thrown");
        }

        return ResponseEntity.ok(
                Map.of(
                        "name", "Zee",
                        "age", "62",
                        "height", "185",
                        "hairColor", "Black"
                )
        );
    }
}
