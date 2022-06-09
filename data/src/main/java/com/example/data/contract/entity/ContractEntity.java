package com.example.data.contract.entity;

import com.example.business.contract.Contract;
import com.example.business.contract.ContractExt;
import com.multi.country.lib.core.annotations.CountryFieldBinder;
import com.multi.country.lib.core.annotations.FR;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
import java.util.function.BiFunction;

import static com.example.data.contract.entity.ContractEntityFieldsBinder.infoBinder;

@Entity
@Table(name = "Contract")
@Getter
@Setter
public class ContractEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @CountryFieldBinder(constructorParameters = {Contract.class}, countryParameterizedClass = ContractExt.class)
    private ContractInfoEntity info;

    public ContractEntity() {

    }

    public ContractEntity(Contract business) {
        id = business.id();
        name = business.name();
        if(business.ext() != null){
            info = infoBinder.apply(business, business.ext());
            info.setContract(this);
        }
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
        return new Contract(id, name, info.toRecord());
    }
}
