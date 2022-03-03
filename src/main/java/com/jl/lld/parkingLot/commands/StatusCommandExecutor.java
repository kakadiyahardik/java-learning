package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.model.Slot;
import com.jl.lld.parkingLot.service.ParkingLotService;

import java.util.List;

/**
 * @author Hardik Kakadiya
 */
public class StatusCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "status";

    public StatusCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 0;
    }

    @Override
    public void execute(Command command) {
        List<Slot> slots = parkingLotService.getOccupideSlots();

        if (slots.isEmpty()) {
            outputPrinter.parkingLotEmpty();
            return;
        }
        outputPrinter.statusHeader();
        for (Slot slot : slots) {
            outputPrinter.printWithNewLine(slot.getParkedCar() + " : " + slot.getNumber());
        }
    }
}
