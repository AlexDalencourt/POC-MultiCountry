package com.example;

import com.example.multiTenant.TenantRoutingDataSource;
import com.example.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.example.data" })
@EnableJpaRepositories(basePackages = { "com.example.data" })
public class DataSourceConfiguration {

    @Bean(name = "dataSources")
    @Primary
    public Map<Object, Object> getDataSources(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.getDataSources().stream().map(dataSourceProperty -> {
            DataSource dataSource = DataSourceBuilder.create()
                    .url(dataSourceProperty.url())
                    .username(dataSourceProperty.username())
                    .password(dataSourceProperty.password())
                    .driverClassName(dataSourceProperty.driverClassName())
                    .build();
            ((HikariDataSource) dataSource).setSchema(dataSourceProperty.schema());
            return new TenantIdDataSource(dataSourceProperty.tenantId(), dataSource);
        }).collect(Collectors.toMap(TenantIdDataSource::tenantId, TenantIdDataSource::dataSource));
    }

    @Bean(name = "tenantRoutingDataSource")
    @DependsOn("dataSources")
    public DataSource dataSource(Map<Object, Object> dataSources) {
        AbstractRoutingDataSource tenantRoutingDataSource = new TenantRoutingDataSource();
        tenantRoutingDataSource.setTargetDataSources(dataSources);
        tenantRoutingDataSource.setDefaultTargetDataSource(dataSources.get("fr"));
        tenantRoutingDataSource.afterPropertiesSet();
        return tenantRoutingDataSource;
    }


    private record TenantIdDataSource (Object tenantId, Object dataSource) {
    }
}
