package com.supcom.cot.smartirrigation.repositories;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import com.supcom.cot.smartirrigation.entities.Field;
import jakarta.data.repository.Page;
import jakarta.data.repository.Pageable;

import java.util.List;

import java.util.stream.Stream;
@Repository
public interface FieldRepository extends CrudRepository<Field, String> {

    Stream<Field> findAll();

    Stream<Field> findByIdField(Long idField);

    Stream<Field> findByLocation(List<Float> location);
}
