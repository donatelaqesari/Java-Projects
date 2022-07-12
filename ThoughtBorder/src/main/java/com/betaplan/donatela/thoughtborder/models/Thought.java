package com.betaplan.donatela.thoughtborder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "thoughts")
public class Thought {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=5)
    private String description;

    //many thoughts can have one user
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    //make a new table with name likes, foreign key user_id and thought_id
    @JoinTable(name = "likes", joinColumns = @JoinColumn(name = "thought_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> likers; //track a list of likers



    //CONSTRUCTORS
    public Thought() {
    }
    public Thought(Long id, String description, User user, List<User> likers) {
        this.id = id;
        this.description = description;
        this.user = user;
        this.likers = likers;
    }


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getLikers() {
        return likers;
    }

    public void setLikers(List<User> likers) {
        this.likers = likers;
    }
}
