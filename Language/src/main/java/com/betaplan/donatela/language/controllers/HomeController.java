package com.betaplan.donatela.language.controllers;

import com.betaplan.donatela.language.models.Language;
import com.betaplan.donatela.language.services.LanguageService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/")
    public String home() {
        return "redirect:/languages";
    }

    @GetMapping("/languages")
    public String index(Model viewModel) {
        viewModel.addAttribute("allLanguages", this.languageService.getAllLanguages());
        return "index.jsp";
    }

    //ADDING NEW LANGUAGE
    @GetMapping("/new")
    public String add(@ModelAttribute("language") Language language, Model model) {
        return "add.jsp";
    }

    @PostMapping("/new")
    public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "add.jsp";
        }
        this.languageService.createLanguage(language);
        return "redirect:/";
    }

    //EDIT LANGUAGE
    @GetMapping("/edit/{id}")
    public String edit(@ModelAttribute("language") Language language, Model model, @PathVariable("id") Long id) {
        model.addAttribute("language", this.languageService.getOneLanguage(id));
        return "edit.jsp";
    }

    @PostMapping("/edit/{id}")
    public String editLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("language", this.languageService.getOneLanguage(id));
            return "edit.jsp";
        }
        this.languageService.editLanguage(language);
        return "redirect:/";
    }

    //DELETE InFORMATIO for button
    /*@DeleteMapping("/languages/{id}/delete")
    public String delete ( @PathVariable("id") Long id){
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }*/

    //delete when it is a link tag
    @RequestMapping("/languages/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        languageService.deleteLanguage(languageService.getById(id));
        return "redirect:/languages";}

        @GetMapping("/languages/{id}")
                public String viewInfo(@PathVariable("id") Long id, Model model){
            model.addAttribute("language", this.languageService.getById(id));
            return "profile.jsp";

    }
}
