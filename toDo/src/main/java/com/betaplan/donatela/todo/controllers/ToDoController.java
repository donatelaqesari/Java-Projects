package com.betaplan.donatela.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {
    @GetMapping("/")
    public String home(){
        return "index.jsp";
    }

    @GetMapping("/add")
    public String getAddForm(){
        return "addTodo.jsp";
    }
}
