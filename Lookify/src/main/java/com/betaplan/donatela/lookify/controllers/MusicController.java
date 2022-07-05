package com.betaplan.donatela.lookify.controllers;

import com.betaplan.donatela.lookify.models.Music;
import com.betaplan.donatela.lookify.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private  MusicService musicService;

    @RequestMapping("/")
    public String start() {
        return "start.jsp";
    }

    @RequestMapping("/dashboard")
    public String dashboard(@ModelAttribute("songName") Music song, Model model){
        List<Music> songs = musicService.allSongs();
        model.addAttribute("songs",songs);
        return "dashboard.jsp";
    }

    @PostMapping("songs/new")
    public String add(@Valid @ModelAttribute("music") Music song, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return"add.jsp";
        }
        else {
            musicService.addSong(song);
            return"redirect:/dashboard";
        }
    }

    @GetMapping("songs/new")
    public String add(@ModelAttribute("music") Music song) {
        return"add.jsp";
    }

    @DeleteMapping("/dashboard/{songId}")
    public String destroy(@PathVariable("songId") Long id) {
        musicService.deleteSong(id);
        return"redirect:/dashboard";
    }

    @RequestMapping("/songs/{songId}")
    public String info(@PathVariable("songId") Long id, Model model) {
        Music song = musicService.findSong(id);
        model.addAttribute("song",song);
        return "info.jsp";
    }

    @RequestMapping("search/topten")
    public String topTen(Model model) {
        List<Music> top = musicService.topTen();
        model.addAttribute("top",top);
        return "top.jsp";

    }

    @PostMapping ("/search")
    public String search(@ModelAttribute("songName") Music song) {
        return"redirect:/search/"+song.getName();
    }

    @RequestMapping("/search/{search}")
    public String result(@ModelAttribute("songName") Music song,@PathVariable("search")String search, Model model) {
        List<Music> results = musicService.searchBy(search);
        model.addAttribute("search",search);
        model.addAttribute("results",results);
        return "search.jsp";
    }




}
