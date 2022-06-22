package com.javastack.spring.daikichipathvariable.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //accept request from the client
@RequestMapping("/daikichi")
public class DaikichiController {
    @RequestMapping("")
    public String daikichi() {
        return "Welcome!";
    }

    @RequestMapping("/today")
    public String daikichiToday() {
        return "Today you will find luck in all your endeavors!";
    }

    @RequestMapping("/tomorrow")
    public String daikichiTomorrow() {
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

    @RequestMapping("/now")
    public String index(@RequestParam(value = "q") String searchQuery) {
        return "You searched for: " + searchQuery;
    }

    @RequestMapping("/travel/{travel}")
    public String daikichiTravel(@PathVariable("travel") String city) {
        return "Congratulations! You will soon travel to " + city + " !";
    }

    @RequestMapping("/lotto/{lotto}")
    public String daikichiNum(@PathVariable("lotto") Integer number) {
        if(number %2 != 0){
            return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        }
        else return "You will take a grand journey in the near future, but be weary of tempting offers.";
    }
}
