package com.betaplan.donatela.albums.controllers;

import com.betaplan.donatela.albums.models.Album;
import com.betaplan.donatela.albums.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private AlbumService aService;

    @GetMapping("")
    public List<Album> index() {
        return this.aService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public Album getONe(@PathVariable("id") Long id) {
        return this.aService.getOneAlbum(id);
    }

    @PostMapping("/create")
    public Album create(Album album) {
        return this.aService.createAlbum(album);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return this.aService.deleteAlbum(id);
    }
}
