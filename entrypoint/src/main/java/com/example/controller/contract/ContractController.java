package com.example.controller.contract;

import com.example.business.contract.Contract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ContractController {

//    private final CountryBusinessResolver business;


    public ContractController(
//            CountryBusinessResolver business
    ) {
//        this.business = business;
    }

    @PostMapping
    public ResponseEntity<Contract> newContract(@RequestBody String name){
//        return new ResponseEntity<>(business.resolve().save(new Contract(null, name)), HttpStatus.OK);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable UUID id){
//        return new ResponseEntity<>(business.resolve().getById(id), HttpStatus.OK);
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<List<Contract>> getAllContract(){
//        return new ResponseEntity<>(business.resolve().getAll(), HttpStatus.OK);
        return null;
    }
}
