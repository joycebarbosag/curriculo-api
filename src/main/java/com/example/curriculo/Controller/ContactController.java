package com.example.curriculo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.curriculo.Model.ContactModel;
import com.example.curriculo.Service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
    
    @Autowired
    ContactService contactService;

    @GetMapping("/{id}")
    public ResponseEntity<ContactModel> getPersonById(@PathVariable Long id) {
        try {
            ContactModel contact = contactService.getContactById(id);
            return ResponseEntity.ok(contact);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ContactModel>> getAllContacts() {
        List<ContactModel> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }
}
