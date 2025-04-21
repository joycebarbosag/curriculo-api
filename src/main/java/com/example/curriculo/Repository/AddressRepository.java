package com.example.curriculo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo.Model.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    
}
