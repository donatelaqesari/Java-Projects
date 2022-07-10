package com.betaplan.donatela.alldogs.repositories;

import com.betaplan.donatela.alldogs.models.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
}
