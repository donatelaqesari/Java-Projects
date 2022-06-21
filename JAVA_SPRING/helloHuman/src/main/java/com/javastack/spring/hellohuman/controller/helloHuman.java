package com.javastack.spring.hellohuman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greeter")
public class helloHuman {
    @RequestMapping("")
    public String index(@RequestParam(value = "name", required = false) String searchName,
                        @RequestParam(value = "last_name", required = false) String searchLastName) {
        String person;
        if (searchName == null && searchLastName == null) {
            person = "Human";
        } else if (searchName != null && searchLastName != null) {
            person = searchName + " " + searchLastName;
        } else {
            person =
        searchName== null ?
                    "Esteemed Citizen " + searchLastName :
                    "Esteemed Citizen " + searchName;
        }
        return String.format(
                "<a href='/'>Go Back</a>"
                        + "<h1>Hello %s!</h1>"
                        + "", person);
    }
}

