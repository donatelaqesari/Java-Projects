package com.betaplan.donatela.albums.services;

import com.betaplan.donatela.albums.models.Song;
import com.betaplan.donatela.albums.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    @Autowired
    private SongRepository sRepo;

    public Song create(Song song){
        return this.sRepo.save(song);
    }
}
