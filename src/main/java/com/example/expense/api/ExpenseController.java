package com.example.expense.api;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public void createExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Expense getExpenseDetail(@PathVariable Integer id) {
        return expenseService.getExpenseById(id);
    }

    @GetMapping
    public String getAllExpenses(Model model) {
        List<Expense> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    @PutMapping
    public void updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
    }
}
