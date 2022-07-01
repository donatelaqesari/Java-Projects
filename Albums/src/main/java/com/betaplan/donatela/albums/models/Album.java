package com.betaplan.donatela.albums.models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "albums")
public class Album {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //increment by one
    private Long id;
    @Size(min = 2, max = 200)
    private String albumName;
    @NotBlank
    private String bandName;

    @NotNull
    @Min(1700)
    private Integer year;

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

    public Album() {
    }

    public Album(String albumName, String bandName, Integer year) {
        this.albumName = albumName;
        this.bandName = bandName;
        this.year = year;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
