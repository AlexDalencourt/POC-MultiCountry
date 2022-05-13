package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "spring")
public class DataSourceProperties {
    private final List<DataSourceProperty> dataSources;

    public DataSourceProperties(List<DataSourceProperty> dataSources) {
        this.dataSources = dataSources;
    }

    public List<DataSourceProperty> getDataSources() {
        return dataSources;
    }
}
