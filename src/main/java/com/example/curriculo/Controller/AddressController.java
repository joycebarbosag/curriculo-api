package com.example.curriculo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.curriculo.Model.AddressModel;
import com.example.curriculo.Service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
    
    @Autowired
    AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<AddressModel> getPersonById(@PathVariable Long id) {
        try {
            AddressModel address = addressService.getAddressById(id);
            return ResponseEntity.ok(address);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AddressModel>> getAllAddresses() {
        List<AddressModel> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }
}
