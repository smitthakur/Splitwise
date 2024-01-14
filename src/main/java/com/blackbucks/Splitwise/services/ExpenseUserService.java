package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.models.Expense;
import com.blackbucks.Splitwise.models.ExpenseUser;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ExpenseUserService {
    public List<Expense> getExpenses(int id);
    public ExpenseUser getExpenseUser(int id);
}
