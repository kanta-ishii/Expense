package com.example.expense.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseMapper expenseMapper;

    public void addExpense(Expense expense) {
        expenseMapper.insertExpense(expense);
    }

    public Expense getExpenseById(Integer id) {
        return expenseMapper.getExpenseById(id);
    }

    public List<Expense> getAllExpenses() {
        return expenseMapper.getAllExpenses();
    }

    public void updateExpense(Expense expense) {
        expenseMapper.updateExpense(expense);
    }

    public void deleteExpense(Integer id) {
        expenseMapper.deleteExpense(id);
    }
}
