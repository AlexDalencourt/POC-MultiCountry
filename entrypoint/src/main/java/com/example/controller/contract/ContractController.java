package com.example.controller.contract;

import com.example.business.contract.Contract;
import com.example.business.contract.ContractBusiness;
import com.example.business.country.resolver.CountryBusinessResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ContractController {

    private final CountryBusinessResolver<ContractBusiness> business = null;


    public ContractController(
//            CountryBusinessResolver<ContractBusiness> business
    ) {
//        this.business = business;
    }

    @PostMapping
    public ResponseEntity<Contract> newContract(@RequestBody String name){
        return new ResponseEntity<>(business.resolve().save(new Contract(null, name)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContract(@PathVariable UUID id){
        return new ResponseEntity<>(business.resolve().getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Contract>> getAllContract(){
        return new ResponseEntity<>(business.resolve().getAll(), HttpStatus.OK);
    }
}
