package com.ingeneo.services.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    private static final int MAX_POOL_SIZE = 10;
    private static final int CONNECTION_TIMEOUT = 5000;

    @Bean
    public DataSource createDataSource(@Value("${spring.datasource.driverClassName}") String driverClass) {
        String urlDB = "jdbc:postgresql://localhost:5432/ingeneo?currentSchema=shingeneo";
        String password = "Cami1036+";
        String userName = "postgres";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(urlDB);
        config.setUsername(userName);
        config.setPassword(password);
        config.setDriverClassName(driverClass);
        config.setMaximumPoolSize(MAX_POOL_SIZE);
        config.setConnectionTimeout(CONNECTION_TIMEOUT);
        return new HikariDataSource(config);
    }
}
