package com.blackbucks.Splitwise.dtos;

import com.blackbucks.Splitwise.models.Currency;
import lombok.Data;


import java.util.Date;
import java.util.List;
@Data
public class ExpenseDTO extends BaseModelDTO{
    private double amount;
    private Date addedAt;
    private String description;
    private String proofUrl;
    private Currency currency;
    List<ExpenseUserDTO> expenseUsers;
}
