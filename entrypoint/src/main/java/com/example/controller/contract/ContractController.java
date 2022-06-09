package com.example.controller.contract;

import com.example.business.contract.Contract;
import com.example.business.contract.ContractBusinessResolver;
import com.example.controller.contract.dto.ContractInput;
import com.example.controller.contract.validators.ContractInputValidatorResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ContractController {

    private final ContractBusinessResolver business;
    private final ContractInputValidatorResolver validator;


    public ContractController(
            ContractBusinessResolver business,
            ContractInputValidatorResolver validator) {
        this.business = business;
        this.validator = validator;
    }

    @PostMapping
    public <T extends ContractInput> ResponseEntity<Contract> newContract(@RequestBody T input){
        if(validator.validate(input)){
            return new ResponseEntity<>(business.save(new Contract(null, input.getName(), input.toBusinessExt())), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
