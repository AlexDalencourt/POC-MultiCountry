package com.example.business.country.resolver;

import com.example.business.country.declaration.Country;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryBusinessResolver<T> {

    private static final String DEFAULT_COUNTRY_CODE = "international";

    private Map<String, T> beansByCountry;

    public CountryBusinessResolver(List<T> services) {
        beansByCountry = services.stream().collect(Collectors.toUnmodifiableMap(
                service ->
                        Optional.ofNullable(getClass().getAnnotation(Country.class))
                                .map(Country::value).orElse(DEFAULT_COUNTRY_CODE),
                service -> service,
                (bean1, bean2) -> {throw new NoUniqueBeanDefinitionException(bean1.getClass(), bean1.toString(), bean2.toString());}
        ));
    }

    public T bean(String country) {
        return beansByCountry.get(country);
    }

    public T defaultBean() {
        return beansByCountry.get(DEFAULT_COUNTRY_CODE);
    }
}
