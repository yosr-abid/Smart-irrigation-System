package com.supcom.cot.smartirrigation.repositories;

import com.supcom.cot.smartirrigation.entities.Field;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.Repository;
import com.supcom.cot.smartirrigation.entities.Parcel;

import java.util.List;

import java.util.stream.Stream;

@Repository
public interface ParcelRepository extends CrudRepository<Parcel, String> {

    Stream<Parcel> findAll();

    List<Parcel> findByIdField(String idField);

}
