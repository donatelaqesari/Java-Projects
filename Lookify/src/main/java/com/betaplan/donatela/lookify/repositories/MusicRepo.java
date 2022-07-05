package com.betaplan.donatela.lookify.repositories;

import java.util.List;

import com.betaplan.donatela.lookify.models.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MusicRepo extends CrudRepository<Music, Long> {
    List<Music> findAll();
    List<Music> findTop10ByOrderByRatingDesc();
    List<Music> findByArtistContainsAllIgnoreCase(String search);
}
