package com.example.controller.contract.validators;

import com.example.controller.contract.dto.ContractInput;
import com.multi.country.lib.core.annotations.CountryResolver;
import org.springframework.stereotype.Component;

@CountryResolver
@Component
public class ContractInputValidator {

    public boolean validate(ContractInput input){
        return input.getName() != null && !input.getName().isBlank();
    }
}
