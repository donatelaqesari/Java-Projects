package com.betaplan.donatela.studentroster.services;

import com.betaplan.donatela.studentroster.models.Student;
import com.betaplan.donatela.studentroster.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository sRepo;

    public Student createStudent(Student student){
        return this.sRepo.save(student);
    }

}
