package com.example.business.contract;

import com.multi.country.lib.core.annotations.EN;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@EN
@Service
@Slf4j
public class ContractBusinessEN extends ContractBusiness {

    public ContractBusinessEN(ContractRepository repository) {
        super(repository);
    }

    @Override
    public Contract save(Contract contract){
        log.info("Specific EN save method");

        return super.save(contract);
    }

    @Override
    public Contract getById(UUID id){
        log.info("Specific EN getById method");

        return super.getById(id);
    }

    @Override
    public List<Contract> getAll(){
        log.info("Specific EN getAll method");
        return super.getAll();
    }
}
