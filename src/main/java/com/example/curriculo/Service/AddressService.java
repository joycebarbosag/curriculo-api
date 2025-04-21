package com.example.curriculo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curriculo.Model.AddressModel;
import com.example.curriculo.Repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    public AddressModel getAddressById(Long id){
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found."));
    }

    public List<AddressModel> getAllAddresses(){
        return addressRepository.findAll();
    }
}
