package com.rainbowland.service;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mapping.model.SimpleTypeHolder;
import org.springframework.data.r2dbc.convert.MappingR2dbcConverter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.DialectResolver;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;
import org.springframework.data.r2dbc.mapping.R2dbcMappingContext;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractServiceConfiguration {

    protected final ConnectionFactory connectionFactory(R2dbcProperties properties) {
        ConnectionFactoryOptions baseOptions = ConnectionFactoryOptions.parse(properties.getUrl());
        ConnectionFactoryOptions.Builder ob = ConnectionFactoryOptions.builder().from(baseOptions)
        .option(ConnectionFactoryOptions.USER, properties.getUsername())
        .option(ConnectionFactoryOptions.PASSWORD, properties.getPassword());
        ConnectionFactory connectionFactory = ConnectionFactories.get(ob.build());
        ConnectionPoolConfiguration configuration = ConnectionPoolConfiguration.builder(connectionFactory)
                .maxIdleTime(properties.getMaxIdleTime())
                .maxSize(properties.getMaxSize())
                .maxAcquireTime(properties.getMaxAcquireTime())
                .initialSize(properties.getInitialSize())
                .validationQuery(properties.getValidationQuery())
                .maxCreateConnectionTime(properties.getMaxCreateConnectionTime())
                .maxAcquireTime(properties.getMaxAcquireTime())
                .acquireRetry(properties.getAcquireRetry())
                .build();
        return new ConnectionPool(configuration);
    }

    protected final DatabaseClient databaseClient(ConnectionFactory cf) {
        R2dbcDialect dialect = DialectResolver.getDialect(cf);
        return DatabaseClient.builder()
                .connectionFactory(cf)
                .bindMarkers(dialect.getBindMarkersFactory())
                .build();
    }

    protected final R2dbcEntityTemplate r2dbcEntityTemplate(DatabaseClient databaseClient) {
        Assert.notNull(databaseClient, "DatabaseClient must not be null!");
        R2dbcDialect dialect = DialectResolver.getDialect(databaseClient.getConnectionFactory());
        List<Object> converters = new ArrayList<>(dialect.getConverters());
        converters.addAll(R2dbcCustomConversions.STORE_CONVERTERS);

        SimpleTypeHolder simpleTypeHolder = dialect.getSimpleTypeHolder();
        R2dbcCustomConversions r2dbcCustomConversions = new R2dbcCustomConversions(CustomConversions.StoreConversions.of(simpleTypeHolder, converters), getCustomConverters());

        R2dbcMappingContext context = new R2dbcMappingContext(NamingStrategy.INSTANCE);
        context.setSimpleTypeHolder(r2dbcCustomConversions.getSimpleTypeHolder());
        //customized MappingR2dbcConverter
        MappingR2dbcConverter converter = new IdOptionalR2dbcConverter(context, r2dbcCustomConversions);
        return new R2dbcEntityTemplate(databaseClient, dialect, converter);
    }

    protected List<Converter<?, ?>> getCustomConverters() {
        return Collections.emptyList();
    }


}
