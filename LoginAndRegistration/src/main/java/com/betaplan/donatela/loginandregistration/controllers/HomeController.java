package com.betaplan.donatela.loginandregistration.controllers;

import com.betaplan.donatela.loginandregistration.models.Book;
import com.betaplan.donatela.loginandregistration.models.User;
import com.betaplan.donatela.loginandregistration.services.BookService;
import com.betaplan.donatela.loginandregistration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller

public class HomeController {
    //After creating book repo and service do the autowired
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    //DISPLAY THE TABLE WITH ALL THE BOOKS
    @GetMapping("/books")
    public String showBooks(HttpSession session, Model model) {
        if (session.getAttribute("user__id") == null) {
            return "redirect:/logout";
        }
        //To display the user (Hi,..)
        User user = this.userService.getOneUser((Long) session.getAttribute("user__id")); // e shkr vete user__id
        model.addAttribute("user", user);

        model.addAttribute("allBooks", this.bookService.allBooks());
        return "dashboard.jsp";
    }

    //SHOW THE DETAILS
    @GetMapping("/books/{id}")
    public String showBooks(@PathVariable("id") Long id, HttpSession session, Model model) {

        Long userId = (Long) session.getAttribute("user__id");
        if (userId == null) {
            return "redirect:/logout";
        }

        model.addAttribute("user", userService.getOneUser(userId));

        Book book = bookService.getOneBook(id);
        model.addAttribute("book", book);

        return "show_book.jsp";
    }


    //ADD NEW BOOK
    @GetMapping("/newBook")
    public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
        if (session.getAttribute("user__id") == null) {
            return "redirect:/logout";
        }

        return "new_book.jsp";
    }

    @PostMapping("/newBook")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "new_book.jsp";
        } else {
            bookService.create(book);

            return "redirect:/books";
        }
    }

    // EDIT BUTTON
    @GetMapping("/books/edit/{id}")
    public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {

        if (session.getAttribute("user__id") == null) {
            return "redirect:/logout";
        }

        model.addAttribute("theBook", this.bookService.getOneBook(id));
        return "edit_book.jsp";
    }

    @PutMapping("/books/edit/{id}")
    public String update(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("book") Book book,
            BindingResult result,
            HttpSession session) {

        if (session.getAttribute("user__id") == null) {
            return "redirect:/logout";
        }

        if (result.hasErrors()) {
            return "edit_book.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
}
