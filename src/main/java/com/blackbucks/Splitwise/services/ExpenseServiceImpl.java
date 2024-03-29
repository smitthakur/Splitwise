package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.ExpenseRepositories.ExpenseRepository;
import com.blackbucks.Splitwise.dtos.ExpenseDTO;
import com.blackbucks.Splitwise.models.Expense;
import com.blackbucks.Splitwise.models.Group;
import com.blackbucks.Splitwise.models.GroupExpense;
import com.blackbucks.Splitwise.utils.ExpenseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupService groupExpense;
    @Autowired
    GroupExpenseService groupExpenseService;
    @Override
    public Expense getExpense(int id) {
        return this.expenseRepository.findById(id).get();
    }

    @Override
    public List<Expense> getAllExpense() {
        return this.expenseRepository.findAll();
    }

    @Override
    @Transactional
    public Expense createExpense(ExpenseDTO dto, int groupId){
        /*
            1. Convert ExpenseDTO to Expense - Done
            2. Save Expense to the DB - Done
            3. Update Group_Expense table.
         */
        Expense expense = ExpenseUtils.mapToExpense(dto);
        System.out.println("******** Expense " + expense);
        expense = this.expenseRepository.save(expense);

        if(groupId != -1){
            Group group = this.groupService.getGroup(groupId);
            GroupExpense groupExpense = new GroupExpense();
            groupExpense.setExpense(expense);
            groupExpense.setGroup(group);
            this.groupExpenseService.createGroupExpense(groupExpense);
        }
        return expense;
    }
}
