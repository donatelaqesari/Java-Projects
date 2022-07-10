package com.betaplan.donatela.dojosninjas.controllers;

import com.betaplan.donatela.dojosninjas.models.Dojo;
import com.betaplan.donatela.dojosninjas.models.Ninja;
import com.betaplan.donatela.dojosninjas.services.DojoNinjaServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    private final DojoNinjaServices dojoNinjaServices;


    public HomeController(DojoNinjaServices dojoNinjaServices) {
        this.dojoNinjaServices = dojoNinjaServices;
    }
    @GetMapping("/")
    public String index(){
        return "redirect:/dojos";
    }


    @GetMapping("/dojos")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
        List<Dojo> dojos = dojoNinjaServices.allDojos();
        model.addAttribute("dojos", dojos);
        return "dojo.jsp";
    }
    @PostMapping("/dojos")
    public String addDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "dojo.jsp";
        }
        else {
            dojoNinjaServices.addDojo(dojo);
            return "redirect:/dojos";
        }
    }

    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
       // List<Ninja> ninjas = dojoNinjaServices.allNinjas();
        Ninja ninja = dojoNinjaServices.findNinja(id);
        model.addAttribute("dojoDetails", ninja);
        return "index.jsp";
    }

    @GetMapping("/ninjas")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        //same as GetMapping for dojo but we do not create the list here
        model.addAttribute("dojos", dojoNinjaServices.allDojos());
        return "ninja.jsp";
    }
    @PostMapping("/ninjas")
    public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "ninja.jsp";
        }
        else {
            dojoNinjaServices.addNinja(ninja);
            return "redirect:/dojos/" + ninja.getDojoIsReady().getNinjas();
        }
    }



}


