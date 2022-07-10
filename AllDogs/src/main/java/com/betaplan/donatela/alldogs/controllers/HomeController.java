package com.betaplan.donatela.alldogs.controllers;

import com.betaplan.donatela.alldogs.services.DogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private DogService dogService;

    @GetMapping("/")
    public String dogs(Model model){
        model.addAttribute("allDogs", dogService.getAll());
        return "index.jsp";
    }

    @GetMapping("/dogs/new")
    public String newDog(){
        return "newDog.jsp";
    }
}
