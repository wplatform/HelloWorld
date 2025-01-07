package com.github.azeroth.hotfixes.boot;

import com.github.azeroth.cache.CacheProvider;
import com.github.azeroth.dbc.DbcObjectManager;
import com.github.azeroth.hotfixes.HotfixesDbcObjectManager;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories(
        basePackages = "com.github.mmo.hotfixes.repository",
        transactionManagerRef = "worldTransactionManager"
)
public class DbcAutoConfiguration extends AbstractJdbcConfiguration {

    @Bean
    DbcObjectManager dbcObjectManager(CacheProvider cacheProvider) {
        return new HotfixesDbcObjectManager(cacheProvider);
    }


    @Bean
    @ConfigurationProperties(prefix = "worldserver.hotfixdatabaseinfo")
    DataSource hotfixesDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean
    NamedParameterJdbcOperations hotfixesNamedParameterJdbcOperations() {
        return new NamedParameterJdbcTemplate(hotfixesDataSource());
    }


    @Bean
    public DataSourceTransactionManager hotfixesTransactionManager() {
        return new DataSourceTransactionManager(hotfixesDataSource());
    }

}
