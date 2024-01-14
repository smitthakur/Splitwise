package com.blackbucks.Splitwise.dtos;

import lombok.Data;

import java.util.List;
@Data
public class AddGroupDTO extends BaseModelDTO{
    private String name;
    private String description;
    private List<Integer> users;
    private List<Integer> admins;
}
