package com.supcom.cot.smartirrigation.entities;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import jakarta.json.bind.annotation.JsonbVisibility;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Sensor implements Serializable  { // Sensor entity for MQTT messages. This entity will be used to broadcast sensor data on websocket
    @Id
    private String id; //Sensor ID

    @Column
    private Double moistureValue; //Value from the moisture sensor
    @Column
    private Double tempValue; //Value from the temperature sensor
    @Column
    private Double humidityValue; //Value from the humidity sensor
    @Column
    private Double longitude; //Value of longitude
    @Column
    private Double latitude; //Value of latitude
    public Sensor() {
    }



    public Sensor(String id, Double moistureValue, Double tempValue, Double humidityValue) {
        this.id = id;
        this.moistureValue = moistureValue;
        this.tempValue = tempValue;
        this.humidityValue = humidityValue;

    }

    public Sensor(String id, Double moistureValue, Double tempValue, Double humidityValue, Double longitude, Double latitude) {
        this.id = id;
        this.moistureValue = moistureValue;
        this.tempValue = tempValue;
        this.humidityValue = humidityValue;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    //Getters
    public String getId() {
        return id;
    }

    public Double getMoistureValue() {
        return moistureValue;
    }

    public Double getTempValue() {
        return tempValue;
    }

    public Double getHumidityValue() {
        return humidityValue;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sensor)) {
            return false;
        }
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", moistureValue=" + moistureValue +
                ", tempValue=" + tempValue +
                ", humidityValue=" + humidityValue +
                ", long=" + longitude +
                ", lat" + latitude +

                '}';
    }

}
