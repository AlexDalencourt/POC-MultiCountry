package com.example.properties;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;

public record DataSourceProperty(String tenantId, String url, String schema, String username, String password, String driverClassName,
                                 LiquibaseProperties liquibase) {
}
