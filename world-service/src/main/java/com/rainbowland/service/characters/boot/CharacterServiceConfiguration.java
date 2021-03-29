package com.rainbowland.service.characters.boot;

import com.rainbowland.service.AbstractServiceConfiguration;
import com.rainbowland.service.R2dbcProperties;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.reactive.TransactionalOperator;

import java.util.ArrayList;
import java.util.List;

@Configurable
public class CharacterServiceConfiguration extends AbstractServiceConfiguration {

    @Bean
    @ConfigurationProperties("datasource.characters")
    public R2dbcProperties characterR2dbcProperties() {
        return new R2dbcProperties();
    }

    @Bean
    public ConnectionFactory characterConnectionFactory(@Qualifier("characterR2dbcProperties") R2dbcProperties properties) {
        return super.connectionFactory(properties);
    }

    @Bean
    public DatabaseClient characterDatabaseClient(@Qualifier("characterConnectionFactory") ConnectionFactory connectionFactory) {
        return super.databaseClient(connectionFactory);
    }
    @Bean
    public R2dbcEntityTemplate characterR2dbcEntityTemplate(@Qualifier("characterDatabaseClient") DatabaseClient databaseClient) {
        return super.r2dbcEntityTemplate(databaseClient);
    }

    @Override
    protected List<Converter<?, ?>> getCustomConverters() {
        List<Converter<?, ?>> converterList = new ArrayList<>();

        return converterList;
    }


}
