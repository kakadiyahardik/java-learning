package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.model.Slot;
import com.jl.lld.parkingLot.service.ParkingLotService;

import java.util.Optional;

/**
 * @author Hardik Kakadiya
 */
public class RegiNumberToSlotCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "slot_number_for_registration_number";

    public RegiNumberToSlotCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        Optional<Slot> slot = parkingLotService.getSlotsForRegiNumber(command.getParams().get(0));

        if (!slot.isPresent()) {
            outputPrinter.notFound();
        } else {
            outputPrinter.printWithNewLine("Car is parked on Slot: " + slot.get().getNumber());
        }
    }
}
