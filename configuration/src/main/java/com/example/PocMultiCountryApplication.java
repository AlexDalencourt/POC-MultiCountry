package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.example", exclude = {LiquibaseAutoConfiguration.class })
public class PocMultiCountryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocMultiCountryApplication.class, args);
    }



}
