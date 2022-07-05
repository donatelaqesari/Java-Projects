package com.betaplan.donatela.albums.repositories;

import com.betaplan.donatela.albums.models.Album;
import org.hibernate.loader.collection.SubselectOneToManyLoader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findAll(); //SELECT * FROM albums
    //List<Album> findByAlbumNameContaining(String containing);
    //List<Album> findByTop10OrderByYearAsc();
    //boolean existByAlbumName(String albumName);
}
