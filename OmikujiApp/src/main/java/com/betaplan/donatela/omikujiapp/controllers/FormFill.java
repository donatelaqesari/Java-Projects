package com.betaplan.donatela.omikujiapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormFill {
    @RequestMapping("/")
    public String omikuji (){
        return "index.jsp";
    }
}
