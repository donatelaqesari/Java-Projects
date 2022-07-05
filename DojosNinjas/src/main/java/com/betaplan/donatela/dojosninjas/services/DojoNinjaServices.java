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

    private DojoRepository dRepo;

    private NinjaRepository nRepo;


    public void addDojo(Dojo dojo) {
        dRepo.save(dojo);
    }
    public List<Dojo> allDojos() {
        return (List<Dojo>) this.dRepo.findAll();
    }
    public void addNinja(Ninja ninja) {
        nRepo.save(ninja);
    }
    public List<Ninja> allNinjas() {
        return (List<Ninja>) nRepo.findAll();
    }
    public Dojo findDojo(Long id) {
        return this.dRepo.findById(id).orElse(null);
    }
    public Dojo findNinja(Long id) {
        return this.dRepo.findById(id).orElse(null);
    }
}
