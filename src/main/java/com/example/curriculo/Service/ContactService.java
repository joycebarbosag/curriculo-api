package com.example.curriculo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curriculo.Model.ContactModel;
import com.example.curriculo.Repository.ContactRepository;

@Service
public class ContactService {
    
    @Autowired
    ContactRepository contactRepository;

    public ContactModel getContactById(Long id){
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found."));
    }

    public List<ContactModel> getAllContacts(){
        return contactRepository.findAll();
    }
}
