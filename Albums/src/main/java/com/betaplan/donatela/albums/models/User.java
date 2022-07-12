package com.betaplan.donatela.albums.models;

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
    private String password;
    @Transient //we dont want to store it in the database
    private String confirmPassword;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Album> myAlbums;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"
            )
    )
    private List<Album> albumsLiked;


    //CONSTRUCTORS
    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    //GETTERS AND SETTERS

    public List<Album> getMyAlbums() {
        return myAlbums;
    }

    public void setMyAlbums(List<Album> myAlbums) {
        this.myAlbums = myAlbums;
    }

    public List<Album> getAlbumsLiked() {
        return albumsLiked;
    }

    public void setAlbumsLiked(List<Album> albumsLiked) {
        this.albumsLiked = albumsLiked;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
