package com.betaplan.donatela.thoughtborder.controllers;

import com.betaplan.donatela.thoughtborder.models.User;
import com.betaplan.donatela.thoughtborder.services.UserService;
import com.betaplan.donatela.thoughtborder.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/")
    public String login(@ModelAttribute("user") User user) {
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }
        User newUser = this.userService.registerUser(user);
        session.setAttribute("user__id", newUser.getId());
        return "redirect:/thoughts/dashboard";
    }

    @PostMapping("/login")
    private String login(HttpSession session, @RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttributes) {
        if (!this.userService.authenticateUser(email, password)) {
            redirectAttributes.addFlashAttribute("loginError", "Invalid Credentials");
            return "redirect:/";
        }
        User userToBeLoggedIn = this.userService.getUserByEmail(email);
        session.setAttribute("user__id", userToBeLoggedIn.getId());
        return "redirect:/thoughts/dashboard";
    }

    //for the user model TO LOGOUT
    @GetMapping("/logout")
    private String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

