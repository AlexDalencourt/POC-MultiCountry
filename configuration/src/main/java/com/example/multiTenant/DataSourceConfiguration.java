package com.example.multiTenant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    public DataSourceConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource() {
        TenantRoutingDataSource customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(dataSourceProperties.getDatasource());
        return customDataSource;
    }

}
