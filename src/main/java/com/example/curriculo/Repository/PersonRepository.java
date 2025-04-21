package com.example.curriculo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo.Model.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long>{
    
}
