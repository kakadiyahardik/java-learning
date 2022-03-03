package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.model.Slot;
import com.jl.lld.parkingLot.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hardik Kakadiya
 */
public class ColorsToSlotNumberCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "slot_numbers_for_cars_with_colour";

    public ColorsToSlotNumberCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        List<Slot> slotsForColor = parkingLotService.getSlotsForColor(command.getParams().get(0));

        if (slotsForColor.isEmpty()) {
            outputPrinter.notFound();
        } else {
            String result = slotsForColor.stream()
                    .map(slot -> slot.getNumber() + "")
                    .collect(Collectors.joining(", "));

            outputPrinter.printWithNewLine(result);
        }
    }
}
