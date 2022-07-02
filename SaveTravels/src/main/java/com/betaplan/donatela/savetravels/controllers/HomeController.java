package com.betaplan.donatela.savetravels.controllers;

import com.betaplan.donatela.savetravels.models.Expense;
import com.betaplan.donatela.savetravels.services.ExpenseService;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller

public class HomeController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String home() {
        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
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

    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable("id") Long id, @ModelAttribute("newExpense") Expense expense, Model viewModel) {
        viewModel.addAttribute("newExpense", this.expenseService.getOneExpense(id));
        return "edit.jsp";
    }

    /*@PutMapping("/edit/{id}")
    public String update(
            @PathVariable("id") Long id,
            Model model,
            @Valid @ModelAttribute("expense") Expense expense,
            BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/edit/{id}";
        }else {
            expenseService.editExpense(expense);
            return "redirect:/expenses";
        }
    }*/

    @PostMapping("/edit/{id}")
    public String edit(@Valid @ModelAttribute("newExpense") Expense expense, BindingResult result, @PathVariable("id") Long id, Model viewModel) {
        if (result.hasErrors()) {

            viewModel.addAttribute("newExpense", this.expenseService.getOneExpense(id));
            return "edit.jsp";
        }
        this.expenseService.editExpense(expense);
        return "redirect:/";
    }

    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/";
    }

    @GetMapping("/expenses/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("expense", expenseService.getById(id));
        return "profile.jsp";
    }

    //done before modelAttribute
   /* @PostMapping("/htmladd")
    public String htmlAdd(@RequestParam("expenseName") String expense,
                          @RequestParam("vendorName") String vendor,
                          @RequestParam("amount") Float amount,
                          @RequestParam("description") String description) {
        //assemble the createExpense function from the service
        Expense expenseToSave = new Expense(expense, vendor, amount, description);
        this.expenseService.createExpense(expenseToSave);
        return "redirect:/";
    }*/
}
