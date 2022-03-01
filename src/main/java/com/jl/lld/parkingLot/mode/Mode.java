package com.jl.lld.parkingLot.mode;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.commands.CommandExecutor;
import com.jl.lld.parkingLot.commands.CommandExecutorFactory;
import com.jl.lld.parkingLot.exceptions.InvalidCommandException;
import com.jl.lld.parkingLot.model.Command;

import java.io.IOException;

/**
 * @author Hardik Kakadiya
 */
public abstract class Mode {

    protected CommandExecutorFactory commandExecutorFactory;
    protected OutputPrinter outputPrinter;

    public Mode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    protected void processCommand(Command command) {
        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);

        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException("invalid command: " + command.toString());
        }
    }

    public abstract void process() throws IOException;
}
