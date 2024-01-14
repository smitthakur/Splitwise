package com.blackbucks.Splitwise.controllers;

import com.blackbucks.Splitwise.dtos.AddGroupDTO;
import com.blackbucks.Splitwise.dtos.Response;
import com.blackbucks.Splitwise.dtos.UserDTO;
import com.blackbucks.Splitwise.models.Group;
import com.blackbucks.Splitwise.models.User;
import com.blackbucks.Splitwise.services.GroupService;
import com.blackbucks.Splitwise.utils.GroupUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserController userController;
    @GetMapping("/{groupId}")
    public List<UserDTO> getAllUsersByGroupId(@PathVariable int groupId){
        List<User> users = groupService.getAllUsersByGroupId(groupId);
        List<UserDTO> list = new ArrayList<>();
        for (User user : users) {
            UserDTO userDto = new UserDTO();
            userDto.setId(user.getId());
            userDto.setName(user.getUsername());
            userDto.setPhoneNo(user.getPhoneNo());
            list.add(userDto);
        }

        return list;
    }

    @PostMapping("/")
    public Response addGroup(@RequestBody AddGroupDTO groupDto){
        Group group = GroupUtils.mapToGroup(groupDto);
        int id = this.groupService.addGroup(group);
        return Response.getSuccessResponse("Group Added Id = " + id);
    }

    @PutMapping("/")
    public Response updateGroup(@RequestBody AddGroupDTO groupDto){
        if(Objects.isNull(groupDto.getId())) return Response.getFailureResponse("No Group Found. Invalid or Null Group");
        Group group= GroupUtils.mapToGroup(groupDto);
        group = this.groupService.updateGroup(group);
        return Response.getSuccessResponse("Group Updated Successfully.! group Id = " + group.getId());
    }
}
