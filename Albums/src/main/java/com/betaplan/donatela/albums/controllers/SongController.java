package com.betaplan.donatela.albums.controllers;

import com.betaplan.donatela.albums.models.Album;
import com.betaplan.donatela.albums.models.Song;
import com.betaplan.donatela.albums.services.AlbumService;
import com.betaplan.donatela.albums.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/new")
    public String create(@ModelAttribute("song") Song song, Model model){
        model.addAttribute("albums", this.albumService.getAllAlbums());
        return "/songs/new.jsp";
    }
    @PostMapping("/newSong")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result){
        Long idAlbum= song.getAlbumSongIsON().getId();
        if(result.hasErrors()){
            return "songs/new.jsp";
        }
        this.songService.create(song);
        return "redirect:/details/" + idAlbum;
    }

}
