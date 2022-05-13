package com.example.business.contract;

import java.util.List;
import java.util.UUID;

public interface ContractRepository {

    Contract save(Contract entity);

    Contract findById(UUID id);

    List<Contract> findAll();
}
