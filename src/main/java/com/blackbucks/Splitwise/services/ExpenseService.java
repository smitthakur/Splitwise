package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.dtos.ExpenseDTO;
import com.blackbucks.Splitwise.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ExpenseService {
    Expense getExpense(int id);
    List<Expense> getAllExpense();
    Expense createExpense(ExpenseDTO expense, int groupId);
}
