package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SettleUpService {
    List<Transaction> settleGroup(int groupId);
    List<Transaction> settleUser(int userId);
}
