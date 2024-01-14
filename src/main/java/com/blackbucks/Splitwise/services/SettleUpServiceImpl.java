package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.ExpenseRepositories.GroupExpenseRepository;
import com.blackbucks.Splitwise.models.Expense;
import com.blackbucks.Splitwise.models.Transaction;
import com.blackbucks.Splitwise.models.User;
import com.blackbucks.Splitwise.strategies.SettleUpStrategy;
import com.blackbucks.Splitwise.utils.ExpenseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class SettleUpServiceImpl implements SettleUpService{
    @Autowired
    private GroupExpenseRepository groupExpenseRepository;
    @Autowired
    private SettleUpStrategy settleUpStrategy;
    @Autowired
    private ExpenseUserService expenseUserService;
    @Override
    public List<Transaction> settleGroup(int groupId) {
        List<Expense> expenses = groupExpenseRepository.findByGroup_Id(groupId).stream().map(a -> a.getExpense()).collect(Collectors.toList());
        Map<User,Double> map = ExpenseUtils.aggregateExpenses(expenses);
        return settleUpStrategy.settleUp(map);
    }

    @Override
    public List<Transaction> settleUser(int userId) {
        List<Expense> expenses = this.expenseUserService.getExpenses(userId);
        Map<User,Double> map = ExpenseUtils.aggregateExpenses(expenses);
        return settleUpStrategy.settleUp(map);
    }
}
