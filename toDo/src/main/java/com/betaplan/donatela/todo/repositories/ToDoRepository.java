package com.betaplan.donatela.todo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findall();
}
