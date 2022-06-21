package com.javastack.spring.daikichipathvariable.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //accept request from the client
@RequestMapping("/daikichi")
public class DaikichiController {
    @RequestMapping("")
    public String daikichi(){
        return "Welcome!";
    }
    @RequestMapping("/today")
    public String daikichiToday(){
        return "Today you will find luck in all your endeavors!";
    }
    @RequestMapping("/tomorrow")
    public String daikichiTomorrow(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
    @RequestMapping("/now")
    public String index(@RequestParam(value="q") String searchQuery) {
        return "You searched for: " + searchQuery;
    }
}
