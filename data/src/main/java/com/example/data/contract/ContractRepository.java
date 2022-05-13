package com.example.data.contract;

import com.example.data.contract.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface ContractRepository extends JpaRepository<ContractEntity, UUID> {

}
