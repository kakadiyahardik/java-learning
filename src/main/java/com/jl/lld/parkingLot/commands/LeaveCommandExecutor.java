package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.service.ParkingLotService;

/**
 * @author Hardik Kakadiya
 */
public class LeaveCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        int slotNumber = Integer.parseInt(command.getParams().get(0));
        parkingLotService.leave(slotNumber);
        outputPrinter.printWithNewLine("Slot number " + slotNumber + " is free");
    }
}
