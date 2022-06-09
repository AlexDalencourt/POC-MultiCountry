package com.example.data.contract.entity;

import com.example.business.contract.Contract;
import com.example.business.contract.ContractExt;
import com.multi.country.lib.core.annotations.FR;

import java.util.function.BiFunction;

public class ContractEntityFieldsBinder {

    public static final BiFunction<Contract, ContractExt, ContractInfoEntity> infoBinder =
            (contract, infos) -> {
                FR instance = infos.getClass().getAnnotation(FR.class);
                if(instance != null){
                    return new ContractInfoEntityFR(contract);
                }
                return new ContractInfoEntity(contract);
            };

}
