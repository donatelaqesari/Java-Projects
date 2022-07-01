package com.betaplan.donatela.dogspring.repositories;

import com.betaplan.donatela.dogspring.models.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
    List<Dog> findAll();
}
