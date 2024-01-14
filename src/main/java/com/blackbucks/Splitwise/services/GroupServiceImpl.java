package com.blackbucks.Splitwise.services;

import com.blackbucks.Splitwise.ExpenseRepositories.GroupRepository;
import com.blackbucks.Splitwise.models.Group;
import com.blackbucks.Splitwise.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupRepository groupRepository;
    @Override
    public List<User> getAllUsersByGroupId(int groupId) {
        return groupRepository.findUsersById(groupId);
    }

    @Override
    public int addGroup(Group group) {
        group = groupRepository.save(group);
        return group.getId();
    }

    @Override
    public Group getGroup(int id) {
        return this.groupRepository.findById(id).get();
    }

    @Override
    public Group updateGroup(Group group) {
        return this.groupRepository.save(group);
    }
}
