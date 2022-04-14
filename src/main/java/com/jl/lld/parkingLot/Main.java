package com.jl.lld.parkingLot;

import com.jl.lld.parkingLot.commands.CommandExecutorFactory;
import com.jl.lld.parkingLot.mode.InteractiveMode;
import com.jl.lld.parkingLot.service.ParkingLotService;

import java.io.IOException;

/**
 * @author Hardik Kakadiya
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ParkingLotService parkingLotService = new ParkingLotService();
        com.jl.lld.parkingLot.OutputPrinter outputPrinter = new com.jl.lld.parkingLot.OutputPrinter();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService,
                outputPrinter);

        new InteractiveMode(commandExecutorFactory, outputPrinter).process();
    }
}
