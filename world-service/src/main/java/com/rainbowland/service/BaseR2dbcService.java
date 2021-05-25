package com.rainbowland.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.core.ReactiveSelectOperation;
import org.springframework.data.r2dbc.core.ReactiveUpdateOperation;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Getter
@RequiredArgsConstructor
public abstract class BaseR2dbcService implements R2dbcService {



    protected final R2dbcEntityTemplate template;


    public <T> Mono<T> insert(T entity) {
        return template.insert(entity);
    }

    public <T> Mono<T> delete(T entity) {
        return template.delete(entity);
    }

    public <T> Mono<T> update(T entity) {
        return template.update(entity);
    }

    public ReactiveUpdateOperation.ReactiveUpdate update(Class<?> entityClass) {
        return template.update(entityClass);
    }

    public <T> Flux<T> select(Query query, Class<T> clazz) {
        return template.select(query, clazz);
    }

    @Override
    public <T> ReactiveSelectOperation.ReactiveSelect<T> select(Class<T> clazz) {
        return template.select(clazz);
    }

    public <T> Mono<T> selectOne(Query query, Class<T> clazz) {
        return template.selectOne(query, clazz);
    }

}
