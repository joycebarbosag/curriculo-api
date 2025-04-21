package com.example.curriculo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AddressModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streetName;
    private String cityName;
    private String stateName;
    private String countryName;
    private int houseNumber;
    private String extraInfo;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private PersonModel person;
}
