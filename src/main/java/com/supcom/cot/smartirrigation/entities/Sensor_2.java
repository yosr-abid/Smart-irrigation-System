package com.supcom.cot.smartirrigation.entities;

import com.supcom.cot.smartirrigation.entities.FieldPropertyVisibilityStrategy;
import com.supcom.cot.smartirrigation.entities.SensorType;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import jakarta.json.bind.annotation.JsonbVisibility;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Sensor_2 implements Serializable {

    @Id
    private String idSensor;

    @Column
    private String idParcel;
    @Column
    private SensorType sensorType;

    @Column
    private int sensorValue;

    public Sensor_2(){

    }

    public String getIdParcel() {
        return idParcel;
    }

    public void setIdParcel(String idParcel) {
        this.idParcel = idParcel;
    }

    public Sensor_2(String idSensor, SensorType sensorType, String idParcel,int sensorValue){
        this.idSensor=idSensor;
        this.sensorType=sensorType;
        this.idParcel = idParcel;
        this.sensorValue=sensorValue;
    }

    public double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public String getSensorType() {
        return String.valueOf(sensorType);
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor_2 sensor = (Sensor_2) o;
        return Objects.equals(idSensor, sensor.idSensor) && sensorType == sensor.sensorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSensor, sensorType);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "idParcel=" + idParcel +
                ", idSensor=" + idSensor +
                ", sensorType=" + sensorType +
                ", sensorValue=" + sensorValue +
                '}';
    }

}
