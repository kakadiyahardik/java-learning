package com.jl.lld.parkingLot.mode;

import com.jl.lld.parkingLot.OutputPrinter;
import com.jl.lld.parkingLot.commands.CommandExecutorFactory;
import com.jl.lld.parkingLot.commands.ExitCommandExecutor;
import com.jl.lld.parkingLot.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hardik Kakadiya
 */
public class InteractiveMode extends Mode {
    public InteractiveMode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        super(commandExecutorFactory, outputPrinter);
    }

    public void process() throws IOException {
        outputPrinter.welcome();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            Command command = new Command(input);
            processCommand(command);

            if (command.getName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}
