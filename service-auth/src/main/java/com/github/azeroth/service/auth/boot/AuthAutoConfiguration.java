package com.github.azeroth.service.auth.boot;

import com.github.azeroth.service.auth.repository.BattlenetAccountRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories(
        basePackageClasses = BattlenetAccountRepository.class,
        transactionManagerRef = "authTransactionManager"
)
public class AuthAutoConfiguration extends AbstractJdbcConfiguration {


    @Bean
    @ConfigurationProperties(prefix = "bnetserver.logindatabaseinfo")
    DataSource authDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean
    public DataSourceTransactionManager authTransactionManager() {
        return new DataSourceTransactionManager(authDataSource());
    }

}
