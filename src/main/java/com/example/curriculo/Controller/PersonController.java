package com.example.curriculo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.curriculo.Model.PersonModel;
import com.example.curriculo.Service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<PersonModel> createPerson (@RequestBody PersonModel person){
        try{
            PersonModel savedPerson = personService.createPerson(person);
            return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonModel> getPersonById(@PathVariable Long id) {
        try {
            PersonModel person = personService.getPersonById(id);
            return ResponseEntity.ok(person);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PersonModel>> getAllPerson() {
        List<PersonModel> persons = personService.getAllPerson();
        return ResponseEntity.ok(persons);
    }

}
