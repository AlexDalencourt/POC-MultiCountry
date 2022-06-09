package com.example.data.contract.entity;

import com.example.business.contract.Contract;
import com.example.business.contract.ContractExt;
import com.example.business.contract.ContractExtFR;
import com.multi.country.lib.core.annotations.FR;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("fr")
@FR
public class ContractInfoEntityFR extends ContractInfoEntity{

    private String siret;

    public ContractInfoEntityFR(Contract businessObject){
        super(businessObject);
        this.siret = ((ContractExtFR)businessObject.ext()).getSiret();
    }

    @Override
    public ContractExtFR toRecord() {
        return new ContractExtFR(super.getId(), siret);
    }
}
