package com.betaplan.donatela.alldogs.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 20)
    private String name;
    @NotBlank
    private String breed;
    @NotNull
    private Integer age;
    private boolean houseBroken;

    @Column(updatable = false)
    @DateTimeFormat(pattern="yyy-MM-DD HH-mm-ss")
    private Date createdAt;
    @DateTimeFormat(pattern="yyy-MM-DD HH-mm-ss")
    private Date updatedAt;

    @PrePersist
    protected void onCreate()
    {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public Dog() {
    }

    public Dog(Long id, String name, String breed, Integer age, boolean houseBroken, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.houseBroken = houseBroken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isHouseBroken() {
        return houseBroken;
    }

    public void setHouseBroken(boolean houseBroken) {
        this.houseBroken = houseBroken;
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
}
