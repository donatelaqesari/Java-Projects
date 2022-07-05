package com.betaplan.donatela.albums.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //increment by one
    private Long id;

    private String name;
    private String length;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album albumSongIsON;

    public Album getAlbumSongIsON() {
        return albumSongIsON;
    }

    public void setAlbumSongIsON(Album albumSongIsON) {
        this.albumSongIsON = albumSongIsON;
    }

    public Song() {
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
