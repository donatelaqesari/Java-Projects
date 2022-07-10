package com.betaplan.donatela.studentroster.repositories;

import com.betaplan.donatela.studentroster.models.Dorm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll(); //SELECT * FROM dorms
}
