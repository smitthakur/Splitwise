package com.blackbucks.Splitwise.dtos;

import lombok.Data;

@Data
public class RegisterUserRequestDto {
    private String username;
    private String password;
    private String phoneNo;
}