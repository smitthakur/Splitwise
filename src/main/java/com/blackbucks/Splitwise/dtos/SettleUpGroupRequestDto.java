package com.blackbucks.Splitwise.dtos;

import lombok.Data;

@Data
public class SettleUpGroupRequestDto {
    private int groupId;
    private String description;
}
