package com.rainbowland.service;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.r2dbc.convert.MappingR2dbcConverter;
import org.springframework.data.relational.core.mapping.RelationalPersistentEntity;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.util.function.BiFunction;

public class IdOptionalR2dbcConverter extends MappingR2dbcConverter {

    public IdOptionalR2dbcConverter(MappingContext<? extends RelationalPersistentEntity<?>, ? extends RelationalPersistentProperty> context, CustomConversions conversions) {
        super(context, conversions);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> BiFunction<Row, RowMetadata, T> populateIdIfNecessary(T object) {
        Assert.notNull(object, "Entity object must not be null!");
        Class<?> userClass = ClassUtils.getUserClass(object);
        RelationalPersistentEntity<?> entity = getMappingContext().getRequiredPersistentEntity(userClass);
        RelationalPersistentProperty idProperty = entity.getIdProperty();
        // the entity have not the @Id property，do not populate to support the current multiple columns key entity.
        if(idProperty == null) {
            return (row, metadata) -> object;
        } else {
            return super.populateIdIfNecessary(object);
        }
    }
}
