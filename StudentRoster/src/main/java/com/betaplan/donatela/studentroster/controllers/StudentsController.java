package com.betaplan.donatela.studentroster.controllers;

import com.betaplan.donatela.studentroster.models.Student;
import com.betaplan.donatela.studentroster.services.DormService;
import com.betaplan.donatela.studentroster.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentsController {
    @Autowired
    StudentService studentService;

    @Autowired
    private DormService dormService;

    @GetMapping("/newStudent")
    public String create(@ModelAttribute("student") Student student, Model model){
        model.addAttribute("dorms", this.dormService.getAllDorms());
        return "new_student.jsp";
    }
    @PostMapping("/newStudent")
    public String addSong(@Valid @ModelAttribute("student") Student student, BindingResult result){
        Long idDorm= student.getDorm().getId();
        if(result.hasErrors()){
            return "new_student.jsp";
        }
        this.studentService.createStudent(student);
        return "redirect:/dorms/" + idDorm;
    }
}
