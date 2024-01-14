package com.blackbucks.Splitwise.dtos;

import lombok.Data;

@Data
public class UserDTO extends BaseModelDTO{
    private int id;
    private String name;
    private String phoneNo;
}
