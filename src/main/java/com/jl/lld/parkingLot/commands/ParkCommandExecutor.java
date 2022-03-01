package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.exceptions.NoFreeSlotAvailableException;
import com.jl.lld.parkingLot.model.Car;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.service.ParkingLotService;

/**
 * @author Hardik Kakadiya
 */
public class ParkCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "park";

    public ParkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(Command command) {
        Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            int allottedSlot = this.parkingLotService.parkCar(car);

            outputPrinter.printWithNewLine("Allotted car: " + car.toString() + " to slot: " + allottedSlot);
        } catch (NoFreeSlotAvailableException exception) {
            outputPrinter.parkingLotFull();
        }
    }
}
