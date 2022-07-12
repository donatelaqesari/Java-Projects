package com.betaplan.donatela.albums.models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

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

    //for one to many relationishp
    //an array list that keeps track of every single song object (albumsongison)
    //mapedby is the descriptor of the albumsongIsOn
    @OneToMany(mappedBy = "albumSongIsON", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"
            )
    )
    private List<User> likers;

    public List<User> getLikers() {
        return likers;
    }

    public void setLikers(List<User> likers) {
        this.likers = likers;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

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
