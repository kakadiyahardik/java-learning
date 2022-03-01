package com.jl.lld.parkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Hardik Kakadiya
 */
@Getter
@Setter
public class Command {
    private static final String SEPARATOR = " ";
    private String name;
    private List<String> params;


}
