package com.betaplan.donatela.book.controllers;

import com.betaplan.donatela.book.models.Book;
import com.betaplan.donatela.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books/{bookId}")
    public String index(Model model,  @PathVariable("bookId") Long bookId){
        System.out.println(bookId);
        Book book = bookService.findBook(bookId);

        ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();

        model.addAttribute("book", book);
        model.addAttribute("allBooks", books);
        return "index.jsp";
    }
}