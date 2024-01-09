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
public class Parcel implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idParcel;

    @Column("field")
    private String idField;

    @Column("name")
    public String name;

   /* private List<Float> location;
    @Column
    private String plants;
*/

    public Parcel() {
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public Parcel(String idParcel, String name) {
        this.idParcel=idParcel;
        this.name=name;
    }
    /*
        public List<Float> getLocation() {
            return location;
        }

        public String getPlants() {
            return plants;
        }
    */
    public String getIdParcel() {return idParcel;}
    public String getName() { return name;}

    public void setIdParcel(String idParcel) {
        this.idParcel = idParcel;
    }
    public void setName(String name) {
        this.name = name;
    }
    /*
        public void setLocation(List<Float> location) {
            this.location = location;
        }

        public void setPlants(String plants) {
            this.plants = plants;
        }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return  idParcel.equals(parcel.idParcel) ;//&& location.equals(parcel.location) && plants.equals(parcel.plants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParcel);// location, plants);
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "idParcel=" + idParcel +
                "name="+name+
                // ", location=" + location +
                //", plants='" + plants + '\'' +
                '}';
    }
}