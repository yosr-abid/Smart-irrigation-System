package com.supcom.cot.smartirrigation.repositories;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import com.supcom.cot.smartirrigation.entities.Sensor;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface SensorRepository extends CrudRepository <Sensor, String> { // repository containing the methods for interacting with SensorDB entity in mongodb
    Stream<Sensor> findAll();

}
