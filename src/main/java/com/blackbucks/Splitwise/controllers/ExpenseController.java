package com.blackbucks.Splitwise.controllers;

import com.blackbucks.Splitwise.dtos.ExpenseDTO;
import com.blackbucks.Splitwise.models.Expense;
import com.blackbucks.Splitwise.services.ExpenseService;
import com.blackbucks.Splitwise.utils.ExpenseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable int id){
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO,@RequestParam("groupId") int groupId){
        Expense expense = this.expenseService.createExpense(expenseDTO,groupId);
        ExpenseDTO response = ExpenseUtils.mapToExpenseDTO(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
