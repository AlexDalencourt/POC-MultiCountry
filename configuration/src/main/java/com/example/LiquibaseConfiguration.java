package com.example;

import com.example.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@ConditionalOnProperty(prefix = "spring.liquibase", name = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(LiquibaseProperties.class)
public class LiquibaseConfiguration {

    private final LiquibaseProperties properties;
    private final DataSourceProperties dataSourceProperties;

    public LiquibaseConfiguration(LiquibaseProperties properties, DataSourceProperties datasourceProperties) {
        this.properties = properties;
        this.dataSourceProperties = datasourceProperties;
    }

    @Bean
    @DependsOn("tenantRoutingDataSource")
    public MultiTenantDataSourceSpringLiquibase liquibaseMultiTenancy(Map<Object, Object> datasources,
                                                                      @Qualifier("taskExecutor") TaskExecutor taskExecutor) {
        // to run changeSets of the liquibase asynchronous
        MultiTenantDataSourceSpringLiquibase liquibase = new MultiTenantDataSourceSpringLiquibase(taskExecutor);
        datasources.forEach((tenant, dataSource) -> liquibase.addDataSource((String) tenant, (DataSource) dataSource));
        dataSourceProperties.getDataSources().forEach(dbProperty -> {
            if (dbProperty.liquibase() != null) {
                liquibase.addLiquibaseProperties(dbProperty.tenantId(), dbProperty.liquibase());
            }
        });

        liquibase.setContexts(properties.getContexts());
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        return liquibase;
    }

}
