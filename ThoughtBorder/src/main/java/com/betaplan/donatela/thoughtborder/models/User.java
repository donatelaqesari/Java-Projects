package com.betaplan.donatela.thoughtborder.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //increment by one
    private Long id;
    @NotBlank
    @Size(max = 15)
    private String firstName;
    @NotBlank
    @Size(max = 30)
    private String lastName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @Transient //we dont want to store it in the database
    private String confirmPassword;

    //one user can have many thought
    //mappedBy is same with " private User user"
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Thought> thoughts;

    @ManyToMany(fetch = FetchType.LAZY)
    //make a new table with name likes, foreign key user_id and thought_id
    @JoinTable(name = "likes", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "thought_id"))
    private List<Thought> likedThoughts; //track a list of thoughts that are being likes

    //CONSTRUCTORS

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, String confirmPassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    //GETTERS AND SETTERS

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Thought> getThoughts() {
        return thoughts;
    }

    public void setThoughts(List<Thought> thoughts) {
        this.thoughts = thoughts;
    }

    public List<Thought> getLikedThoughts() {
        return likedThoughts;
    }

    public void setLikedThoughts(List<Thought> likedThoughts) {
        this.likedThoughts = likedThoughts;
    }
}
