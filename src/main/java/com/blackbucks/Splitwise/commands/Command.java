package com.blackbucks.Splitwise.commands;

import com.blackbucks.Splitwise.exceptions.InvalidCommandException;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Command {
    public void validateAndExecute(String command) throws InvalidCommandException {
        validate(command);
        execute(command);
    }
    public abstract void validate(String command) throws InvalidCommandException;
    public abstract void execute(String command);
}