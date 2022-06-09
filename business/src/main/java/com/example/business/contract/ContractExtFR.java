package com.example.business.contract;

import com.multi.country.lib.core.annotations.FR;
import lombok.Getter;

import java.util.UUID;

@Getter
@FR
public class ContractExtFR extends ContractExt {

    private final String siret;

    public ContractExtFR(String siret) {
        super();
        this.siret = siret;
    }

    public ContractExtFR(UUID id, String siret){
        super(id);
        this.siret = siret;
    }
}
