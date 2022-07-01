package com.betaplan.donatela.savetravels.controllers;

import com.betaplan.donatela.savetravels.models.Expense;
import com.betaplan.donatela.savetravels.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String index(Model viewModel) {
        viewModel.addAttribute("allExpenses", this.expenseService.getAllExpenses());
        return "index.jsp";
    }

    //for adding new expense
    @GetMapping("/new")
    public String add(@ModelAttribute("newExpense") Expense expense) {
        return "add.jsp";
    }

    @PostMapping("/new")
    public String addExpense(@Valid @ModelAttribute("newExpense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "add.jsp";
        }
        this.expenseService.createExpense(expense);
        return "redirect:/";
    }

    //done before modelAttribute
    @PostMapping("/htmladd")
    public String htmlAdd(@RequestParam("expenseName") String expense,
                          @RequestParam("vendorName") String vendor,
                          @RequestParam("amount") Float amount) {
        //assemble the createExpense function from the service
        Expense expenseToSave = new Expense(expense, vendor, amount);
        this.expenseService.createExpense(expenseToSave);
        return "redirect:/";
    }
}
