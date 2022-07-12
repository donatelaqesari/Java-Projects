package com.betaplan.donatela.thoughtborder.controllers;

import com.betaplan.donatela.thoughtborder.models.Thought;
import com.betaplan.donatela.thoughtborder.models.User;
import com.betaplan.donatela.thoughtborder.services.ThoughtService;
import com.betaplan.donatela.thoughtborder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/thoughts")
public class HomeController {

    //Autowired afterdoinf all the thought service and thought repo
    @Autowired
    private UserService userService;
    @Autowired
    private ThoughtService thoughtService;


    @GetMapping("/dashboard")
    // need session to grab user from database, model to view whatever i grabbed from database to page,
    // modelattbr bc i need a jstl form to make a thought and display it there
    public String dashboard(HttpSession session, Model viewModel, @ModelAttribute("thought") Thought thought) {

        //need the logged in user go grab him
        User user = this.userService.getOneUser((Long) session.getAttribute("user__id")); // e shkr vete user__id
        viewModel.addAttribute("user", user);

        //we also want all of our thoughts
        viewModel.addAttribute("allThoughts", this.thoughtService.allThoughts());
        return "dashboard.jsp";
    }

    @PostMapping("/addThought")
    //need httpsession to add user to the thought
    public String addThought(@Valid @ModelAttribute("thought") Thought thought, BindingResult result, Model viewModel, HttpSession session) {
        User user = this.userService.getOneUser((Long) session.getAttribute("user__id"));
        if (result.hasErrors()) {
            viewModel.addAttribute("user", user);
            viewModel.addAttribute("allThoughts", this.thoughtService.allThoughts());
            return "dashboard.jsp";
        }
        thought.setUser(user);
        this.thoughtService.create(thought);
        return "redirect:/thoughts/dashboard";
    }

    //LIKE
    @GetMapping("/{id}/like")
    //session to know who the user is liking
    public String like(HttpSession session, @PathVariable("id") Long id){
        User user = this.userService.getOneUser((Long) session.getAttribute("user__id"));
        Thought thought = this.thoughtService.getOneThought(id);
        this.thoughtService.likeThought(user,thought);
        return "redirect:/thoughts/dashboard";
    }

    //UNLIKE
    @GetMapping("/{id}/unlike")
    //session to know who the user is liking
    public String unlike(HttpSession session, @PathVariable("id") Long id){
        User user = this.userService.getOneUser((Long) session.getAttribute("user__id"));
        Thought thought = this.thoughtService.getOneThought(id);
        this.thoughtService.unlikeThought(user,thought);
        return "redirect:/thoughts/dashboard";
    }

    //DELETE
    @GetMapping("/{id}/delete")
    public String deleteThought(@PathVariable("id") Long id){
        this.thoughtService.deleteThought(id);
        return "redirect:/thoughts/dashboard";
    }
}

