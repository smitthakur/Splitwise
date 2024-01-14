package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.models.Group;
import com.blackbucks.Splitwise.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GroupService {
    public List<User> getAllUsersByGroupId(int groupId);
    public int addGroup(Group group);
    public Group getGroup(int id);
    public Group updateGroup(Group group);
}

