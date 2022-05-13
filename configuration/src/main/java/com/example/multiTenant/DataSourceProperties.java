package com.example.multiTenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

//@Component
//@ConfigurationProperties(prefix = "tenants")
public class DataSourceProperties {

    private Map<Object, Object> datasource = new LinkedHashMap<>();

    public Map<Object, Object> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, Map<String,String>> datasource) {
        datasource
                .forEach((key, value) -> this.datasource.put(key, convert(value)));
    }

    public DataSource convert(Map<String, String> source) {
        return DataSourceBuilder.create()
                .url(source.get("url"))
                .driverClassName(source.get("driverClassName"))
                .username(source.get("username"))
                .password(source.get("password"))
                .build();
    }
}
