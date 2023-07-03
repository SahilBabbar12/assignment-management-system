package com.knoldus.assignment_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Configuration class for the transaction manager.
 */
@Configuration
public class TransactionManagerConfig {

    /**
     * Creates a platform transaction manager using the specified data source.
     *
     * @param dataSource the data source to be used by the transaction manager
     * @return platform transaction manager instance
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
