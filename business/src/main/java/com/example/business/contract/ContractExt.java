package com.example.business.contract;

import com.multi.country.lib.core.annotations.Country;
import com.multi.country.lib.core.annotations.GenericCountry;
import lombok.Getter;

import java.util.UUID;

@Getter
@GenericCountry
@Country
public class ContractExt {
    private final UUID id;

    public ContractExt(){
        this.id = null;
    }

    public ContractExt(UUID id) {
        this.id = id;
    }
}
