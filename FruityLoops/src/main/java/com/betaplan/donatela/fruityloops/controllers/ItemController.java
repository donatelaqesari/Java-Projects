package com.betaplan.donatela.fruityloops.controllers;

import com.betaplan.donatela.fruityloops.models.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class ItemController {
    // ... imports (Use shift+ctrl+O or shift+cmd+O to import as you code)
    @RequestMapping("/")
    public String index(Model model) {

        ArrayList<Items> fruits = new ArrayList<Items>();
        fruits.add(new Items("Kiwi", 1.5));
        fruits.add(new Items("Mango", 2.0));
        fruits.add(new Items("Goji Berries", 4.0));
        fruits.add(new Items("Guava", .75));

        // Add fruits your view model here
        model.addAttribute("allFruits", fruits);
        return "index.jsp";

    }


}



