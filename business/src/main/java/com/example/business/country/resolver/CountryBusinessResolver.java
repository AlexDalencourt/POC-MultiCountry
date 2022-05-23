package com.example.business.country.resolver;

import com.example.business.country.declaration.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class CountryBusinessResolver<T> {

    private static final String DEFAULT_COUNTRY_CODE = "international";

    private final Map<String, T> beansByCountry;

    private final HttpServletRequest request;

    public CountryBusinessResolver(HttpServletRequest request, List<T> services) {
        this.request = request;
        beansByCountry = services.stream().peek(service -> log.info(service.toString())).collect(Collectors.toMap(
                service ->
                        Optional.ofNullable(AnnotatedElementUtils.getMergedAnnotation(service.getClass(), Country.class))
                                .map(Country::value).orElse(DEFAULT_COUNTRY_CODE),
                service -> service,
                (bean1, bean2) -> {throw new NoUniqueBeanDefinitionException(bean1.getClass(), bean1.toString(), bean2.toString());}
        ));
        log.info("Resolver init ok");
    }

    public T bean(String country) {
        return beansByCountry.get(country);
    }

    public T defaultBean() {
        return beansByCountry.get(DEFAULT_COUNTRY_CODE);
    }

    public T resolve() {
        return beansByCountry.getOrDefault(request.getHeader("X-TenantID"), beansByCountry.get(DEFAULT_COUNTRY_CODE));
    }
}
