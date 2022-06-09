package com.example.data.contract.entity;

import com.example.business.contract.Contract;
import com.multi.country.lib.core.annotations.EN;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("en")
@EN
public class ContractInfoEntityEN extends ContractInfoEntity {

    private String name;

    public ContractInfoEntityEN(Contract businessObject) {
        super(businessObject);
        this.name = businessObject.name();
    }
}
