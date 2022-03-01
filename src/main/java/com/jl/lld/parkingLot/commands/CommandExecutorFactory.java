package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.exceptions.InvalidCommandException;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardik Kakadiya
 */
public class CommandExecutorFactory {
    private final Map<String, CommandExecutor> commandExecutorMap = new HashMap<String, CommandExecutor>();

    public CommandExecutorFactory(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        commandExecutorMap.put(CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
        commandExecutorMap.put(ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(parkingLotService, outputPrinter));
        commandExecutorMap.put(ParkCommandExecutor.COMMAND_NAME, new ParkCommandExecutor(parkingLotService,
                outputPrinter));
        commandExecutorMap.put(LeaveCommandExecutor.COMMAND_NAME, new LeaveCommandExecutor(parkingLotService,
                outputPrinter));
    }

    public CommandExecutor getCommandExecutor(Command command) {
        CommandExecutor commandExecutor = commandExecutorMap.get(command.getName());

        if (commandExecutor == null) {
            throw new InvalidCommandException("Invalid Command Name: " + command.getName());
        }

        return commandExecutor;
    }
}
