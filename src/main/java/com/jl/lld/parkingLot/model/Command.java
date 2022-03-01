package com.jl.lld.parkingLot.model;

import com.jl.lld.parkingLot.exceptions.InvalidCommandException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hardik Kakadiya
 */
@Getter
@Setter
@ToString
public class Command {
    private static final String SEPARATOR = " ";
    private String name;
    private List<String> params;

    public Command(String input) {
        List<String> tokenList = Arrays.stream(input.trim().split(SEPARATOR))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokenList.size() == 0) {
            throw new InvalidCommandException();
        }

        name = tokenList.get(0).toLowerCase();
        tokenList.remove(0);
        params = tokenList;
    }
}
