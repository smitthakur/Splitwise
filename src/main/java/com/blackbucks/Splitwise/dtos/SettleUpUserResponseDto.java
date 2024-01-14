package com.blackbucks.Splitwise.dtos;

import com.blackbucks.Splitwise.models.Transaction;
import lombok.Data;

import java.util.List;
@Data
public class SettleUpUserResponseDto {
    private Response response;
    private List<Transaction> transactions;
}
