package com.example.expense.api;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // メインページを表示（expenses.html）
    @GetMapping
    public String getAllExpenses(Model model) {
        List<Expense> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    // 費用の詳細情報を取得するAPI（JSONで返す）
    @GetMapping("/{id}")
    @ResponseBody
    public Expense getExpenseDetail(@PathVariable Integer id) {
        return expenseService.getExpenseById(id);
    }

    // 新しい費用を追加するAPI
    @PostMapping
    @ResponseBody
    public void createExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
    }

    // 既存の費用を更新するAPI
    @PutMapping("/{id}")
    @ResponseBody
    public void updateExpense(@PathVariable Integer id, @RequestBody Expense expense) {
        expense.setId(id);
        expenseService.updateExpense(expense);
    }

    // 費用を削除するAPI
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteExpense(@PathVariable Integer id) {
        expenseService.deleteExpense(id);
    }
}
