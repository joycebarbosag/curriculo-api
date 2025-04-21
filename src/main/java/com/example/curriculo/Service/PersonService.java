package com.example.curriculo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curriculo.Model.PersonModel;
import com.example.curriculo.Repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonModel createPerson(PersonModel person){
        if (person.getAddress() != null) {
            person.getAddress().setPerson(person);
        }
        if (person.getContact() != null) {
            person.getContact().setPerson(person);
        }
        return personRepository.save(person);
    }

    public PersonModel getPersonById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found."));
    }

    public List<PersonModel> getAllPerson(){
        return personRepository.findAll();
    }
    
}
