package com.example.data.contract.entity;

import com.example.business.contract.Contract;
import com.example.business.contract.ContractExt;
import com.multi.country.lib.core.annotations.Country;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contract_ext")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "country")
@DiscriminatorValue("all")
@Country
public class ContractInfoEntity {

    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private ContractEntity contract;

    public ContractInfoEntity(Contract businessObject) {
        this.id = businessObject.id();
    }

    public ContractExt toRecord() {
        return new ContractExt(id);
    }
}
