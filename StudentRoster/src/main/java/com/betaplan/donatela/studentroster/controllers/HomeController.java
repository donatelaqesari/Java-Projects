package com.betaplan.donatela.studentroster.controllers;

import com.betaplan.donatela.studentroster.models.Dorm;
import com.betaplan.donatela.studentroster.models.Student;
import com.betaplan.donatela.studentroster.services.DormService;
import com.betaplan.donatela.studentroster.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private DormService dormService;
@Autowired
private StudentService studentService;
    @GetMapping("/")
    public String index() {
        return "redirect:/dorms";
    }

    @GetMapping("/dorms")
    private String dorms(Model viewModel) {
        viewModel.addAttribute("allDorms", this.dormService.getAllDorms());
        return "index.jsp";
    }

    //ADDING NEW DORM
    @GetMapping("/dorms/new")
    public String add() {
        return "new_dorm.jsp";
    }

    @PostMapping("/dorms/new")
    public String addDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "new_dorm.jsp";
        } else {
            dormService.createDorm(dorm);
            return "redirect:/dorms";
        }
    }

    @GetMapping("/dorms/{id}") // same as <td><a href="/dorms/${dorm.id}">${dorm.name}</a></td>
    public String show(@PathVariable("id") Long id, @ModelAttribute("student") Student student,  Model viewModel){
        viewModel.addAttribute("dormDetails", this.dormService.getOneDorm(id));
        return "show.jsp";
    }

}
