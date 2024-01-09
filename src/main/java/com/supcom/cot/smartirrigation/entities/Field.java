package com.supcom.cot.smartirrigation.entities;

import com.supcom.cot.smartirrigation.entities.FieldPropertyVisibilityStrategy;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import jakarta.json.bind.annotation.JsonbVisibility;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import java.util.UUID;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Field implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idField;
    @Column
    private String name;
    /*@Column
    protected Parcel[] parcels;*/

    public Field(){
    }

    public Field(String idField, String name) {
        this.idField=idField;
        this.name=name;
    }

    public String getIdField() {
        return idField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return idField.equals(field.idField) && name.equals(field.name) ;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idField, name);
        result = 31 * result; //+ Arrays.hashCode(parcels);
        return result;
    }

    @Override
    public String toString() {
        return "Field{" +
                "idField=" + idField +
                ", name=" + name +
                //", parcels=" + Arrays.toString(parcels) +
                '}';
    }
}
