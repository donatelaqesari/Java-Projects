package com.betaplan.donatela.language.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 20)
    private String name;
    @Size(min = 2, max = 20)
    private String creator;
    @NotNull
    private Integer currentVersion;

    public Language() {
    }

    public Language(Long id, String name, String creator, Integer currentVersion) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }
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
    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Integer currentVersion) {
        this.currentVersion = currentVersion;
    }
}
