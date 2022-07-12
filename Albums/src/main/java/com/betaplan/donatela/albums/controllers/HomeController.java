package com.betaplan.donatela.albums.controllers;

import com.betaplan.donatela.albums.models.Album;
import com.betaplan.donatela.albums.models.User;
import com.betaplan.donatela.albums.services.AlbumService;
import com.betaplan.donatela.albums.services.UserService;
import com.betaplan.donatela.albums.validators.UserValidator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller

public class HomeController {
    @Autowired
    private AlbumService albumService;

    //for the user model TO LOGIN
    @Autowired
    private UserService userService;

    @GetMapping("/")
    private String landing(@ModelAttribute("user") User user) {
        return "landing.jsp";
    }

    //FOR THE LOG Registration Validator
    @Autowired
    private UserValidator validator; //go to the post mapping registeruser

    @PostMapping("/registerUser")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        validator.validate(user, result);
        if (result.hasErrors()) {
            return "landing.jsp";
        }
        User newUser = this.userService.registerUser(user);
        session.setAttribute("user__id", newUser.getId());
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    private String login(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttributes) {
        if (!this.userService.authenticateUser(email, password)) {
            redirectAttributes.addFlashAttribute("loginError", "Invalid Credintials");
            return "redirect:/";
        }
        User userToBeLoggedIn = this.userService.getUserByEmail(email);
        session.setAttribute("user__id", userToBeLoggedIn.getId());
        return "redirect:/dashboard";
    }

    //for the user model TO LOGOUT
    @GetMapping("/logout")
    private String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/dashboard")
    public String index(Model viewModel, HttpSession session) {
        if (session.getAttribute("user__id") == null) {
            return "redirect:/";
        }
        viewModel.addAttribute("user", this.userService.getOneUser((Long) session.getAttribute("user__id")));
        viewModel.addAttribute("allAlbums", this.albumService.getAllAlbums());
        return "index.jsp";
    }


    //FOR LIKE
    @GetMapping("/like/{id}")
    private String like(@PathVariable("id") Long id, HttpSession session) {
        User userToLikeAlbum = this.userService.getOneUser((Long) session.getAttribute("user__id"));
        Album albumToLike = this.albumService.getOneAlbum(id);

        //add them together
        this.albumService.likeAlbum(userToLikeAlbum, albumToLike);
        return "redirect:/dashboard";
    }

    //FOR UNLIKE
    @GetMapping("/unlike/{id}")
    private String unlike(@PathVariable("id") Long id, HttpSession session) {
        User userToUnlikeAlbum = this.userService.getOneUser((Long) session.getAttribute("user__id"));
        Album albumToUnlike = this.albumService.getOneAlbum(id);

        //add them together
        this.albumService.unlikeAlbum(userToUnlikeAlbum, albumToUnlike);
        return "redirect:/dashboard";
    }

    //For the profile.jsp
    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable("id") Long id, Model viewModel) {
        viewModel.addAttribute("user", this.userService.getOneUser(id));
        return "profile.jsp";
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
        return "redirect:/dashboard";
    }

    @GetMapping("/details/{id}")
    public String show(@PathVariable("id") Long id, Model viewModel) {
        viewModel.addAttribute("albumDetails", this.albumService.getOneAlbum(id));
        return "show.jsp";
    }

}
