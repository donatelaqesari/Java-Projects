package com.betaplan.donatela.albums.repositories;

import com.betaplan.donatela.albums.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findAll(); //SELECT * FROM albums
}
