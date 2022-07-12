package com.betaplan.donatela.loginandregistration.repositories;

import com.betaplan.donatela.loginandregistration.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll(); //because at the second page ( Hi, Oliver) we see that we need to display all the books
    List<Book> findByUserIdIs(Long userId);
}
