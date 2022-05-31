package com.example.controller.contract;

import com.example.business.contract.Contract;
import com.example.business.contract.ContractBusinessResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ContractController {

    private final ContractBusinessResolver business;


    public ContractController(
            ContractBusinessResolver business
    ) {
        this.business = business;
    }

    @PostMapping
    public ResponseEntity<Contract> newContract(@RequestBody String name){
        return new ResponseEntity<>(business.save(new Contract(null, name)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable UUID id){
        return new ResponseEntity<>(business.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Contract>> getAllContract(){
        return new ResponseEntity<>(business.getAll(), HttpStatus.OK);
    }
}
