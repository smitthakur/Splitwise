package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.ExpenseRepositories.GroupExpenseRepository;
import com.blackbucks.Splitwise.models.GroupExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupExpenseServiceImpl implements GroupExpenseService{
    @Autowired
    private GroupExpenseRepository groupExpenseRepository;
    @Override
    public GroupExpense createGroupExpense(GroupExpense groupExpense) {
        return this.groupExpenseRepository.save(groupExpense);
    }
}
