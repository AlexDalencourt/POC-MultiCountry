package com.example.data.contract.entity;

import com.example.business.contract.Contract;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Contract")
public class ContractEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    public ContractEntity() {

    }

    public ContractEntity(Contract entity) {
        id = entity.id();
        name = entity.name();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contract toRecord(){
        return new Contract(id, name);
    }
}
