package com.betaplan.donatela.omikujiapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class Process {
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String result(@RequestParam(value = "numbers") String numbers, @RequestParam(value = "city") String city, @RequestParam(value = "person") String person, @RequestParam(value = "hobby") String hobby, @RequestParam(value = "thing") String thing, @RequestParam(value = "comment") String comment, HttpSession session){
        session.setAttribute("numbers", numbers);
        session.setAttribute("city", city);
        session.setAttribute("person", person);
        session.setAttribute("hobby", hobby);
        session.setAttribute("thing", thing);
        session.setAttribute("comment", comment);
        return "result.jsp";
    }
}
