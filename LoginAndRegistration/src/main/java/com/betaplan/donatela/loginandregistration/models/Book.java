package com.betaplan.donatela.loginandregistration.models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //increment by one
    private Long id;

    private String title;
    @NotBlank
    @Size(max = 30)
    private String author;

    @Size(min=3, message="Thoughts must be at least 3 characters long")
    private String thoughts;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;



    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    // books can have one user
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;


    //CONSTRUCTOR

    public Book() {
    }

    public Book(Long id, String title, String author, String thoughts, Date createdAt, Date updatedAt, User user) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.thoughts = thoughts;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    //GETTERS AND SETTERS

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
