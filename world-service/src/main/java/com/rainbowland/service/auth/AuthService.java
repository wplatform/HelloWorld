package com.rainbowland.service.auth;

import com.rainbowland.service.R2dbcService;
import com.rainbowland.service.auth.domain.Account;
import com.rainbowland.service.auth.domain.BattlenetAccount;
import org.springframework.data.r2dbc.core.ReactiveSelectOperation;
import org.springframework.data.r2dbc.core.ReactiveUpdateOperation;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthService extends R2dbcService {

    Mono<BattlenetAccount> getBattleNetAccount(String userName);

    Mono<BattlenetAccount> queryBattleNetAccountByLoginTicket(String loginTicket);

    Mono<Account> queryAccountByRealmJoinTicket(long realmId, String realmJoinTicket);


}
