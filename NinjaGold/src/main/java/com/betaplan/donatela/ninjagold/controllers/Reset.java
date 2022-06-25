package com.betaplan.donatela.ninjagold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Reset {
        @RequestMapping("/reset")
        public String reset(HttpSession session) {
            session.removeAttribute("gold");
            return "redirect:/";

    }
}
