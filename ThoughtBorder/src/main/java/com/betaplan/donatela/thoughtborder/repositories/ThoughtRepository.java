package com.betaplan.donatela.thoughtborder.repositories;

import com.betaplan.donatela.thoughtborder.models.Thought;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThoughtRepository extends CrudRepository<Thought, Long> {
    List<Thought> findAll(); //because at the second page ( Hi, Oliver) we see that we need to display all the thought
}
