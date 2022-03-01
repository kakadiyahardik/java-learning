package com.jl.lld.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

/**
 * @author Hardik Kakadiya
 */
public class TestModel {
    JsonObject extraInfo;

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }

    public JsonObject getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(JsonObject extraInfo) {
        this.extraInfo = extraInfo;
    }
}
