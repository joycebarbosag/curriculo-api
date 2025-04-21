package com.example.curriculo.Repository;

import org.springframework.stereotype.Repository;
import com.example.curriculo.Model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Long> {
    
}
