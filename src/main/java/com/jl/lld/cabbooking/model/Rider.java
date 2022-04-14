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
public class Rider {
    private String id;
    private String riderName;

    public Rider(String id) {
        this.id = id;
    }
}
