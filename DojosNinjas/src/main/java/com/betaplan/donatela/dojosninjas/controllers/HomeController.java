package com.betaplan.donatela.dojosninjas.controllers;

import com.betaplan.donatela.dojosninjas.models.Dojo;
import com.betaplan.donatela.dojosninjas.models.Ninja;
import com.betaplan.donatela.dojosninjas.services.DojoNinjaServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final DojoNinjaServices dojoNinjaServices;


    public HomeController(DojoNinjaServices dojoNinjaServices) {
        this.dojoNinjaServices = dojoNinjaServices;
    }

    @RequestMapping("/{id}")
    public String home(@PathVariable("id") Long id, Model model) {
        dojoNinjaServices.findDojo(id);
        model.addAttribute("dojo", dojoNinjaServices.findDojo(id));
        model.addAttribute("ninjas", dojoNinjaServices.findDojo(id).getNinjas());
        return "index.jsp";
    }
    @RequestMapping("/dojos/new")
    public String dojo(@ModelAttribute("newDojo") Dojo dojo) {
        return "dojo";
    }
    @PostMapping("/dojos/new")
    public String newDojo(@ModelAttribute("newDojo") Dojo dojo) {
        dojoNinjaServices.addDojo(dojo);
        return "redirect:/dojos/new";
    }
    @RequestMapping("/ninjas/new")
    public String ninja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoNinjaServices.allDojos());
        return "ninja.jsp";
    }
    @PostMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("newNinja") Ninja ninja, @RequestParam("dojo") String id) {
        Long number= Long.valueOf(id);
        ninja.setDojo(dojoNinjaServices.findDojo(number));
        dojoNinjaServices.addNinja(ninja);
        return "redirect:/ninjas/new";
    }

}


