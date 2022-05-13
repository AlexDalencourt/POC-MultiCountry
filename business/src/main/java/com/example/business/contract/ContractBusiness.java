package com.example.business.contract;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ContractBusiness {

    private final ContractRepository repository;

    public ContractBusiness(ContractRepository repository) {
        this.repository = repository;
    }

    public Contract save(Contract contract){
        return this.repository.save(contract);
    }

    public Contract getById(UUID id){
        return this.repository.findById(id);
    }

    public List<Contract> getAll(){
        return this.repository.findAll();
    }
}
