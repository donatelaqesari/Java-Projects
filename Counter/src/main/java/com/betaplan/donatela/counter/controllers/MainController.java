package com.betaplan.donatela.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(HttpSession session, Model model) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        } else {
            Integer currentCount = (Integer) session.getAttribute("count");
            currentCount++;
            session.setAttribute("count", currentCount);
        }
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model, HttpServletRequest request) {
        Integer currentCounter = 0;
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        } else {
            currentCounter = (Integer) session.getAttribute("count");
        }

        String homeUrl = request.getRequestURL().toString();

        model.addAttribute("count", currentCounter);
        // we remove the last nine characters from homeUrl to match the desired wireframe output (http://localhost:8080 instead of http://localhost:8080/counter/)
        model.addAttribute("page", homeUrl.substring(0,homeUrl.length()-9));
        return "counter.jsp";
    }


}
