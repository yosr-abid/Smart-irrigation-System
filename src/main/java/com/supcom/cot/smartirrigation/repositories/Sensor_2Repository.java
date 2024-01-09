package com.supcom.cot.smartirrigation.repositories;

import com.supcom.cot.smartirrigation.entities.Sensor_2;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import java.util.List;
import java.util.stream.Stream;


@Repository
public interface Sensor_2Repository extends CrudRepository<Sensor_2, String> {
    Stream<Sensor_2> findAll();

    Sensor_2 findByIdSensor(String idSensor);
    List<Sensor_2> findByIdParcel(String idParcel);



}
