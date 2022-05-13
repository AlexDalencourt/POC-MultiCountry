package com.example.data.contract;

import com.example.business.contract.Contract;
import com.example.data.contract.entity.ContractEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ContractRepositoryProxy implements com.example.business.contract.ContractRepository{

    private final ContractRepository repository;

    public ContractRepositoryProxy(ContractRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contract save(Contract entity) {
        return repository.save(new ContractEntity(entity)).toRecord();
    }

    @Override
    public Contract findById(UUID id) {
        return repository.findById(id).map(ContractEntity::toRecord).orElse(null);
    }

    @Override
    public List<Contract> findAll() {
        return repository.findAll().stream().map(ContractEntity::toRecord).collect(Collectors.toList());
    }
}
