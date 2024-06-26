package com.betaplan.donatela.albums.repositories;

import com.betaplan.donatela.albums.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
}
