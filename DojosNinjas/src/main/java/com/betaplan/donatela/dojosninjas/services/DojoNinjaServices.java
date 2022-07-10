package com.betaplan.donatela.dojosninjas.services;

import com.betaplan.donatela.dojosninjas.models.Dojo;
import com.betaplan.donatela.dojosninjas.models.Ninja;
import com.betaplan.donatela.dojosninjas.repositories.DojoRepository;
import com.betaplan.donatela.dojosninjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoNinjaServices {
@Autowired
    private DojoRepository dRepo;
@Autowired
    private NinjaRepository nRepo;

    public DojoNinjaServices(DojoRepository dRepo, NinjaRepository nRepo) {
        this.dRepo = dRepo;
        this.nRepo = nRepo;
    }

    public void addDojo(Dojo dojo) {
        dRepo.save(dojo);
    }
    //Get every single dojo from database
    public List<Dojo> allDojos() {
        return dRepo.findAll();
    }
    public void addNinja(Ninja ninja) {
        nRepo.save(ninja);
    }
    public List<Ninja> allNinjas() {
        return (List<Ninja>) nRepo.findAll();
    }
    // Get one dojo
    public Dojo findDojo(Long id) {
        return this.dRepo.findById(id).orElse(null);
    }
    public Ninja findNinja(Long id) {
        return this.nRepo.findById(id).orElse(null);
    }
}
