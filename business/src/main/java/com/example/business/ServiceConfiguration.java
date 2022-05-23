package com.example.business;

import com.example.business.contract.ContractBusiness;
import com.example.business.country.resolver.CountryBusinessResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
@Slf4j
public class ServiceConfiguration {

    @Bean("toto")
    public CountryBusinessResolver<ContractBusiness> contractBusinessResolver(List<ContractBusiness> byCountry, HttpServletRequest request){
        return new CountryBusinessResolver<>(request,byCountry);
    }
}
