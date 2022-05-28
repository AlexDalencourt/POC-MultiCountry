package com.example.business.contract;

import com.example.multi.country.lib.annotations.FR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@FR
@Service
@Slf4j
public class ContractBusinessFR extends ContractBusiness {

    public ContractBusinessFR(ContractRepository repository) {
        super(repository);
    }

    @Override
    public Contract save(Contract contract){
        log.info("Specific FR save method");

        return super.save(contract);
    }

    public Contract getById(UUID id){
        log.info("Specific FR getById method");

        return super.getById(id);
    }

    public List<Contract> getAll(){
        log.info("Specific FR getAll method");
        return super.getAll();
    }
}
