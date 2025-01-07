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

    @Bean
    @ConfigurationProperties(prefix = "bnetserver.logindatabaseinfo.jpa")
    Properties charactersJpaProperties() {
        //zeroth
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", "none");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.order_inserts", "true");
        jpaProperties.put("hibernate.order_updates", "true");
        jpaProperties.put("hibernate.batch_versioned_data", "true");
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        return jpaProperties;
    }


    @Bean
    LocalContainerEntityManagerFactoryBean authEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(charactersDataSource());
        em.setPackagesToScan("com.pandaria.auth.domain");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setMappingResources("META-INF/jpa-named-queries.xml");
        em.setPersistenceUnitName("character");
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(charactersJpaProperties());
        return em;
    }


    @Bean
    PlatformTransactionManager authTransactionManager(
            @Qualifier("authEntityManagerFactory") LocalContainerEntityManagerFactoryBean todosEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(todosEntityManagerFactory.getObject()));
    }

}
