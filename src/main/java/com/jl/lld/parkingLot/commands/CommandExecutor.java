package com.jl.lld.parkingLot.commands;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.model.Command;
import com.jl.lld.parkingLot.service.ParkingLotService;

/**
 * @author Hardik Kakadiya
 */
public abstract class CommandExecutor {
    public ParkingLotService parkingLotService;
    public OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    /**
     * validate command
     *
     * @param command
     * @return
     */
    public abstract boolean validate(Command command);

    /**
     * execute command
     *
     * @param command
     */
    public abstract void execute(Command command);
}
