package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.model.ParkingLot;
import com.jl.lld.parkingLot.service.ParkingLotService;
import com.jl.lld.parkingLot.strategy.impl.NaturalOrderParkingStrategy;
import com.jl.lld.parkingLot.utils.IntegerValidator;

import java.util.List;

/**
 * @author Hardik Kakadiya
 */
public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(Command command) {
        List<String> params = command.getParams();

        if (params.isEmpty()) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Command command) {
        final int parkingCapacity = Integer.parseInt(command.getParams().get(0));
        ParkingLot parkingLot = new ParkingLot(parkingCapacity);

        parkingLotService.createParkingLot(parkingLot, new NaturalOrderParkingStrategy());

        outputPrinter.printWithNewLine("Parking Lot Created with Capacity " + parkingCapacity);
    }
}
