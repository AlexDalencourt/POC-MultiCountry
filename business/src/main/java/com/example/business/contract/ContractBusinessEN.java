package com.example.business.contract;

import com.example.business.country.declaration.EN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@EN
@Service
@Slf4j
public class ContractBusinessEN {

    private final ContractRepository repository;

    public ContractBusinessEN(ContractRepository repository) {
        this.repository = repository;
    }

    public Contract save(Contract contract){
        log.info("Specific EN save method");

        return this.repository.save(contract);
    }

    public Contract getById(UUID id){
        log.info("Specific EN getById method");

        return this.repository.findById(id);
    }

    public List<Contract> getAll(){
        log.info("Specific EN getAll method");
        return this.repository.findAll();
    }
}
