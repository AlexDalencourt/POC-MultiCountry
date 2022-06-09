package com.example.controller.contract.validators;

import com.example.controller.contract.dto.ContractInput;
import com.example.controller.contract.dto.ContractInputFR;
import com.multi.country.lib.core.annotations.FR;
import org.springframework.stereotype.Component;

@FR
@Component
public class ContractInputValidatorFR extends ContractInputValidator {

    public boolean validate(ContractInputFR input){
        boolean validate = super.validate(input);
        validate &= input.getSiret() != null;

        return validate;
    }
}
