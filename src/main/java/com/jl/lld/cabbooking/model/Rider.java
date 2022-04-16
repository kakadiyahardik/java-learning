package com.jl.lld.cabbooking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Hardik Kakadiya
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rider {
    private String id;
    private String riderName;

    public Rider(String id, String riderName) {
        this.id = id;
        this.riderName = riderName;
    }
}
