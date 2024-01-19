package com.blackbucks.Splitwise.commands;

import com.blackbucks.Splitwise.controllers.UserController;
import com.blackbucks.Splitwise.dtos.LoginUserRequestDTO;
import com.blackbucks.Splitwise.dtos.Response;
import com.blackbucks.Splitwise.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
@Component
public class LoginUserCommand extends Command{
    private UserController userController;
    private static final String LOGIN_USER_COMMAND = "Login";
    @Autowired
    public LoginUserCommand(UserController userController){
        this.userController = userController;
        CommandRegistry.getInstance().register(LOGIN_USER_COMMAND,this);
    }
    @Override
    public void validate(String command) throws InvalidCommandException {
        if(StringUtils.isEmpty(command)){
            throw new InvalidCommandException("Invalid Command");
        }
        String[] splits = command.split(" ");
        if(splits.length < 3 || !splits[0].equals("Login")) {
            throw new InvalidCommandException("Invalid Command.");
        }
    }

    @Override
    public void execute(String command) {
        String[] splits = command.split(" ");
        String username = splits[1];
        String password = splits[2];
        LoginUserRequestDTO dto = new LoginUserRequestDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        Response response = userController.login(dto);
        System.out.println(response.getMessage());
        System.out.println(response.getStatus());
    }
}
