package com.betaplan.donatela.loginandregistration.services;

import com.betaplan.donatela.loginandregistration.models.Book;
import com.betaplan.donatela.loginandregistration.models.User;
import com.betaplan.donatela.loginandregistration.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private final BookRepository bRepo; // we need access to able to throw all the stuff

    public BookService(BookRepository bRepo) {
        this.bRepo = bRepo;
    }

    //Need 4 different things

    //1. Create
    public Book create(Book book) {
        return this.bRepo.save(book);
    }

    //Find all
    public List<Book> allBooks() {
        return this.bRepo.findAll();
    }

    //Get one
    public Book getOneBook(Long id) {
        return this.bRepo.findById(id).orElse(null);
    }

    //Delete
    public void deleteBook(Long id) {
        this.bRepo.deleteById(id);
    }

    //I shtova
    public List<Book> myBooks(User user) {
        return bRepo.findByUserIdIs(user.getId());
    }

    public Book updateBook(Book book) {
        return bRepo.save(book);
    }


}
