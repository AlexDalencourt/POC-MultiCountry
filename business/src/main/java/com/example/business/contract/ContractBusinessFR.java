package com.example.business.contract;

import com.example.business.country.declaration.FR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@FR
@Service
@Slf4j
public class ContractBusinessFR {

    private final ContractRepository repository;

    public ContractBusinessFR(ContractRepository repository) {
        this.repository = repository;
    }

    public Contract save(Contract contract){
        log.info("Specific FR save method");

        return this.repository.save(contract);
    }

    public Contract getById(UUID id){
        log.info("Specific FR getById method");

        return this.repository.findById(id);
    }

    public List<Contract> getAll(){
        log.info("Specific FR getAll method");
        return this.repository.findAll();
    }
}
