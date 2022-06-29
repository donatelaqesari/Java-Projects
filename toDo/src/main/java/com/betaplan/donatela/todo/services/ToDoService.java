package com.betaplan.donatela.todo.services;

import com.betaplan.donatela.todo.repositories.ToDoRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository repository;

    public List<Todo> all(){
        this.repository.findall();
    }
}
