package com.betaplan.donatela.thoughtborder.services;

import com.betaplan.donatela.thoughtborder.models.Thought;
import com.betaplan.donatela.thoughtborder.models.User;
import com.betaplan.donatela.thoughtborder.repositories.ThoughtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThoughtService {
    @Autowired
    private ThoughtRepository tRepo; // we need access to able to throw all the stuff

    //Need three different things

    //1. Create
    public Thought create(Thought thought) {
        return this.tRepo.save(thought);
    }

    //Find all
    public List<Thought> allThoughts() {
        return this.tRepo.findAll();
    }

    //Get one
    public Thought getOneThought(Long id) {
        return this.tRepo.findById(id).orElse(null);
    }

    //Delete
    public void deleteThought(Long id) {
        this.tRepo.deleteById(id);
    }

    //Like
    public void likeThought(User user, Thought thought){
        List<User> usersWhoLiked = thought.getLikers();
        usersWhoLiked.add(user);
        this.tRepo.save(thought);
    }

    //UnLike
    public void unlikeThought(User user, Thought thought){
        List<User> usersWhoLiked = thought.getLikers();
        usersWhoLiked.remove(user);
        this.tRepo.save(thought);
    }
}
