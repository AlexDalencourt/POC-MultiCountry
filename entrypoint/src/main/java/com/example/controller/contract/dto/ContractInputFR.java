package com.example.controller.contract.dto;

import com.example.business.contract.ContractExt;
import com.example.business.contract.ContractExtFR;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractInputFR extends ContractInput {

    private String siret;

    @Override
    public ContractExtFR toBusinessExt() {
        return new ContractExtFR(siret);
    }
}
