package com.betaplan.donatela.dogspring.services;

import com.betaplan.donatela.dogspring.models.Dog;
import com.betaplan.donatela.dogspring.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    @Autowired
    private DogRepository dRepo;

    public List<Dog> getAllDogs(){
        return this.dRepo.findAll();
    }

    // Get one dog
    public Dog getOneDog(Long id) {
        return this.dRepo.findById(id).orElse(null);
    }

    // create a dog
    public Dog createDog(Dog dog) {
        return this.dRepo.save(dog);
    }

    //update dog
    public Dog editExpense(Dog dog) {
        return this.dRepo.save(dog);
    }

    //delete
    public String deleteDog(Long id) {
        this.dRepo.deleteById(id);
        return "Dog has been deleted";
    }
}
