package com.blackbucks.Splitwise.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ExpenseUser extends BaseModel {
    @ManyToOne
    private Expense expense;
    private double amount;
    @ManyToOne
    private User user;
    @Enumerated(value = EnumType.ORDINAL)
    private ExpenseType expenseType;
}
