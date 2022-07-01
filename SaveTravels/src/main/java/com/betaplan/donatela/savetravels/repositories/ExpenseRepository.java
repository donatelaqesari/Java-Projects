package com.betaplan.donatela.savetravels.repositories;

import com.betaplan.donatela.savetravels.models.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAll(); //SELECT * FROM albums
}
