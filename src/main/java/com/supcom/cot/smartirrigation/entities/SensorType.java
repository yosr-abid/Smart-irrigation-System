package com.supcom.cot.smartirrigation.entities;
import java.util.function.Supplier;


public enum SensorType implements Supplier<String> {
    MOISTURE,
    TEMPERATURE,
    HUMIDITY;
    @Override
    public String get() {
        return this.name();
    }

}