package com.jl.lld.cabbooking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Hardik Kakadiya
 */
@Getter
@Setter
@NoArgsConstructor
public class Driver {
    private String id;
    private String name;

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
