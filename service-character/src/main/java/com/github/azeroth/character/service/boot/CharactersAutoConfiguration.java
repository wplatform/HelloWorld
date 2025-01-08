package com.github.azeroth.character.service.boot;

import com.github.azeroth.character.service.repository.BasePackage;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = BasePackage.class,
        entityManagerFactoryRef = "charactersEntityManagerFactory",
        transactionManagerRef = "charactersTransactionManager"
)
public class CharactersAutoConfiguration {


    @Bean
    @ConfigurationProperties(prefix = "bnetserver.logindatabaseinfo")
    DataSource charactersDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }






}
