package com.ds.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends AbstractBaseEntity{
    private String brand;
    private String fuelType;
    private String plate;
    private Integer numberOfDoors;
    private Integer buildYear;
    private Integer plateYear;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    @JsonIgnore
    private Person person;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", plate='" + plate + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", buildYear=" + buildYear +
                ", plateYear=" + plateYear +
                "} " + super.toString();
    }
}
