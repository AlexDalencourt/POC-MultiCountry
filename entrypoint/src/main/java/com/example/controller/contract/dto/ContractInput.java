package com.example.controller.contract.dto;

import com.example.business.contract.ContractExt;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "country", defaultImpl = ContractInput.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContractInputFR.class, name = "fr")
})
public class ContractInput {

    protected String name;

    public ContractExt toBusinessExt(){
        return new ContractExt();
    }

}
