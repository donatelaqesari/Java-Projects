package com.betaplan.donatela.studentroster.services;

import com.betaplan.donatela.studentroster.models.Dorm;
import com.betaplan.donatela.studentroster.repositories.DormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormService {

    @Autowired
    private DormRepository dRepo;

    //Get every single dorm from database
    public List<Dorm> getAllDorms() {
        return this.dRepo.findAll();
    }

    // Get one dorm
    public Dorm getOneDorm(Long id) {
        return this.dRepo.findById(id).orElse(null);
    }

    // create a dorm
    public Dorm createDorm(Dorm dorm) {
        return this.dRepo.save(dorm);
    }

    //update dorm
    public Dorm editDorm(Dorm dorm) {
        return this.dRepo.save(dorm);
    }

    //delete
    public String deleteDorm(Long id) {
        this.dRepo.deleteById(id);
        return "Dorm has been deleted";
    }
}
