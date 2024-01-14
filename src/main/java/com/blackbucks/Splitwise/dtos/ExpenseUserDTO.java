package com.blackbucks.Splitwise.dtos;

import com.blackbucks.Splitwise.models.Expense;
import com.blackbucks.Splitwise.models.ExpenseType;
import com.blackbucks.Splitwise.models.User;
import lombok.Data;

@Data
public class ExpenseUserDTO extends BaseModelDTO{
    private Expense expense;
    private double amount;
    private User user;
    private ExpenseType expenseType;
}
