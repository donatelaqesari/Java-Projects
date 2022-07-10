package com.betaplan.donatela.studentroster.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dorms")
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    //for one to many relationishp
    //an array list that keeps track of every single student object (dorm)
    //mapedby is the descriptor of the "dorm"
    @OneToMany(mappedBy = "dorm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyy-MM-DD HH-mm-ss")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyy-MM-DD HH-mm-ss")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    //CONSTRUCTORS
    public Dorm() {
    }

    public Dorm(Long id, String name, List<Student> students, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //GETTERS AND SETTERS

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
