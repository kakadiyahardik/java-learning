package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.service.ParkingLotService;

import java.util.List;

/**
 * @author Hardik Kakadiya
 */
public class ColorsToRegiNumberCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "registration_numbers_for_cars_with_colour";

    public ColorsToRegiNumberCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        List<String> carNumber = parkingLotService.getCarRegiNumberWithColor(command.getParams().get(0));
        if (carNumber.isEmpty()) {
            outputPrinter.notFound();
        } else {
            outputPrinter.printWithNewLine(carNumber.toString());
        }
    }
}
