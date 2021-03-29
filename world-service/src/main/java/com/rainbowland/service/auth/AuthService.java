package com.rainbowland.service.auth;

import com.rainbowland.service.auth.domain.Account;
import com.rainbowland.service.auth.domain.BattlenetAccount;
import org.springframework.data.r2dbc.core.ReactiveSelectOperation;
import org.springframework.data.r2dbc.core.ReactiveUpdateOperation;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthService {

    <T> Mono<T> insert(T entity);

    <T> Mono<T> delete(T entity);

    <T> Mono<T> update(T entity);

    ReactiveUpdateOperation.ReactiveUpdate update(Class<?> entityClass);

    <T> Flux<T> select(Query query, Class<T> clazz);

    <T> ReactiveSelectOperation.ReactiveSelect<T> select(Class<T> clazz);

    <T> Mono<T> selectOne(Query query, Class<T> clazz);

    Mono<BattlenetAccount> getBattleNetAccount(String userName);

    Mono<BattlenetAccount> queryBattleNetAccountByLoginTicket(String loginTicket);

    Mono<Account> queryAccountByRealmJoinTicket(long realmId, String realmJoinTicket);


}
