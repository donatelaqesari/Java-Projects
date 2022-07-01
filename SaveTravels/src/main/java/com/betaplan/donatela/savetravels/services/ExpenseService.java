package com.betaplan.donatela.savetravels.services;

import com.betaplan.donatela.savetravels.models.Expense;
import com.betaplan.donatela.savetravels.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository eRepo;

    //Get every single expense from database
    public List<Expense> getAllExpenses() {
        return this.eRepo.findAll();
    }

    // Get one expense
    public Expense getOneExpense(Long id) {
        return this.eRepo.findById(id).orElse(null);
    }

    // create an expense
    public Expense createExpense(Expense expense) {
        return this.eRepo.save(expense);
    }

    //update expense
    public Expense editExpense(Expense expense) {
        return this.eRepo.save(expense);
    }

    //delete
    public String deleteExpense(Long id) {
        this.eRepo.deleteById(id);
        return "Expense has been deleted";
    }
}
