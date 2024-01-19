package com.blackbucks.Splitwise.commands;

import com.blackbucks.Splitwise.controllers.UserController;
import com.blackbucks.Splitwise.dtos.RegisterUserRequestDto;
import com.blackbucks.Splitwise.dtos.Response;
import com.blackbucks.Splitwise.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
public class RegisterUserCommand extends Command{
    private static final String REGISTER_COMMAND = "Register";
    private UserController userController;
    @Autowired
    public RegisterUserCommand(UserController userController){
        this.userController = userController;
        CommandRegistry.getInstance().register(REGISTER_COMMAND,this);
    }
    @Override
    public void validate(String command) throws InvalidCommandException {
        if(StringUtils.isEmpty(command)){
            throw new InvalidCommandException("Invalid Command");
        }
        String[] spits = command.split(" ");
        if(!spits[0].equals("Register") || spits.length < 4){
            throw new InvalidCommandException("Invalid Command");
        }

    }

    @Override
    public void execute(String command) {
        String[] splits = command.split(" ");
        String username = splits[1];
        String password = splits[2];
        String phoneNo = splits[3];
        RegisterUserRequestDto dto = new RegisterUserRequestDto();
        dto.setUsername(username);
        dto.setPassword(password);
        dto.setPhoneNo(phoneNo);
        Response response = userController.registerUser(dto);
        System.out.println(response.getMessage());
        System.out.println(response.getStatus());
    }
}