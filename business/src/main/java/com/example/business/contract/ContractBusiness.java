package com.example.business.contract;

import com.multi.country.lib.core.annotations.CountryResolver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@CountryResolver
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

    private void method(){}
    void method3(){}
    protected Void method4(){return null;}

    public static void method2(){}

}
