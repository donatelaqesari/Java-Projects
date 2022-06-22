package com.betaplan.donatela.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "index.jsp";
    }

    @RequestMapping("/date")
    public String date(){
        return "dateTemplate.jsp";
    }

    @RequestMapping("/time")
    public String time(){
        return "timeTemplate.jsp";
    }
}
