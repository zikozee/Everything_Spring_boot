package com.zee.ebs.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 14 Jul, 2026
 */

@Controller
@RequestMapping(path = "test")
public class TestController {

    @GetMapping(path = "me")
    public String test(){
        return "test";
    }

    @GetMapping(path = "json-me")
    @ResponseBody
    public Map<String, String> testJson(){
        return Map.of(
                "name", "Zee",
                "age", "62",
                "height", "185",
                "hairColor", "Black"
        );
    }
}
