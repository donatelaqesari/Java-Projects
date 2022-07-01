package com.betaplan.donatela.dogspring.controllers;

import com.betaplan.donatela.dogspring.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private DogService dogService;
    @GetMapping("/")
    public String index(Model viewModel){
        viewModel.addAttribute("allDogs", this.dogService.getAllDogs());
        return "index.jsp";
    }
}
