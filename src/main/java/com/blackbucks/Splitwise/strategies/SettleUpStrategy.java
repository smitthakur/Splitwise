package com.blackbucks.Splitwise.strategies;

import com.blackbucks.Splitwise.models.Transaction;
import com.blackbucks.Splitwise.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface SettleUpStrategy {
    public List<Transaction> settleUp(Map<User,Double> map);
}
