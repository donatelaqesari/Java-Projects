package com.betaplan.donatela.albums.services;

import com.betaplan.donatela.albums.models.Album;
import com.betaplan.donatela.albums.models.User;
import com.betaplan.donatela.albums.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository aRepo;
   /* public AlbumService(AlbumRepository repository){
        this.aRepo = repository;
    }*/

    //Get every single album from database
    public List<Album> getAllAlbums() {
        return this.aRepo.findAll();
    }

    // Get one album
    public Album getOneAlbum(Long id) {
        return this.aRepo.findById(id).orElse(null);
    }

    // create an album
    public Album createAlbum(Album album) {
        return this.aRepo.save(album);
    }

    //update album
    public Album editAlbum(Album album) {
        return this.aRepo.save(album);
    }

    //delete
    public String deleteAlbum(Long id) {
        this.aRepo.deleteById(id);
        return "Album has been deleted";
    }

    //Like a album
    public void likeAlbum (User user, Album album){
        List<User> userWhoLiked = album.getLikers();
        userWhoLiked.add(user);
        this.aRepo.save(album);
    }

    //Unlike a album
    public void unlikeAlbum (User user, Album album){
        List<User> userWhoLiked = album.getLikers();
        userWhoLiked.remove(user);
        this.aRepo.save(album);
    }

}
