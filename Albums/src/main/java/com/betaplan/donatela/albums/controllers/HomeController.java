package com.betaplan.donatela.albums.controllers;

import com.betaplan.donatela.albums.models.Album;
import com.betaplan.donatela.albums.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/")
    public String index(Model viewModel) {
        viewModel.addAttribute("allAlbums", this.albumService.getAllAlbums());
        return "index.jsp";
    }

    //for adding new album
    @GetMapping("/new")
    public String add() {
        return "add.jsp";
    }

    @PostMapping("/new")
    public String addNew(@RequestParam("albumName") String album,
                         @RequestParam("bandName") String band,
                         @RequestParam("year") Integer year) {
        //assemble the createAlbum function from the service
        Album albumToSave = new Album(album, band, year);
        this.albumService.createAlbum(albumToSave);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String show(@PathVariable("id") Long id, Model viewModel){
        viewModel.addAttribute("albumDetails", this.albumService.getOneAlbum(id));
        return "show.jsp";
    }

}
