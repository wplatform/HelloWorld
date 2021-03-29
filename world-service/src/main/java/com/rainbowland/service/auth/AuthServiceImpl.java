package com.rainbowland.service.auth;

import com.rainbowland.service.auth.domain.*;
import com.rainbowland.service.constants.AuthSqlConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.core.ReactiveSelectOperation;
import org.springframework.data.r2dbc.core.ReactiveUpdateOperation;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final R2dbcEntityTemplate template;


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

    @Override
    public Mono<BattlenetAccount> getBattleNetAccount(String userName) {
        Objects.requireNonNull(userName);
        String condition = userName.matches("/^1[3|4|5|7|8]\\d{9}$/") ? "mobile_phone" : "email";
        userName = userName.toLowerCase();
        return template.selectOne(Query.query(Criteria.where(condition).is(userName)), BattlenetAccount.class);

    }


    @Override
    public Mono<BattlenetAccount> queryBattleNetAccountByLoginTicket(String loginTicket) {
        return template.getDatabaseClient().sql(AuthSqlConstants.LOGIN_BATTLE_NET_ACCOUNT_BY_LOGIN_TICKET)
                .bind("loginTicket", loginTicket)
                .map(row -> {
                    BattlenetAccount bnetAcc = new BattlenetAccount();
                    Account acc = new Account();
                    Realmcharacter rc = new Realmcharacter();
                    Realmlist rl = new Realmlist();
                    AccountLastPlayedCharacter alpc = new AccountLastPlayedCharacter();

                    bnetAcc.setId(row.get("ba_acc_id", Long.class));
                    bnetAcc.setEmail(row.get("ba_email", String.class));
                    bnetAcc.setLocked(row.get("ba_locked", Integer.class));
                    bnetAcc.setLockCountry(row.get("ba_lock_country", String.class));
                    bnetAcc.setLastIp(row.get("ba_last_ip", String.class));
                    bnetAcc.setLoginTicketExpiry(row.get("ba_login_ticket_expiry", Long.class));
                    bnetAcc.setBanned(row.get("ba_baned", Boolean.class));
                    bnetAcc.setPermanentBanned(row.get("ba_permanently_banned", Boolean.class));

                    acc.setId(row.get("acc_id", Long.class));
                    acc.setUsername(row.get("acc_username", String.class));
                    acc.setBattlenetAccount(row.get("ba_acc_id", Long.class));
                    acc.setBanned(row.get("acc_banded", Boolean.class));
                    acc.setPermanentBanned(row.get("acc_permanently_banded", Boolean.class));
                    acc.setSecurityLevel(row.get("acc_security_level", Integer.class));

                    rl.setId(row.get("rl_id", Long.class));
                    rl.setNumchars(row.get("rl_numchars", Integer.class));
                    rl.setBattlegroup(row.get("rl_battlegroup", Integer.class));
                    rl.setRegion(row.get("rl_region", Integer.class));

                    alpc.setAccountId(row.get("lpc_account_id", Long.class));
                    alpc.setRealmId(row.get("lpc_realm_id", Integer.class));
                    alpc.setRegion(row.get("lpc_region", Integer.class));
                    alpc.setBattlegroup(row.get("lpc_battlegroup", Integer.class));
                    alpc.setCharacterName(row.get("lpc_character_name", String.class));
                    alpc.setCharacterGuid(row.get("lpc_character_guid", Long.class));
                    alpc.setLastPlayedTime(row.get("lpc_last_played_time", Long.class));

                    return Map.of("bnetAcc", bnetAcc, "acc", acc, "rc", rc, "rl", rl, "alpc", alpc);
                }).all().collectList().filter(rows -> !rows.isEmpty()).map(rows -> {
                    Map<Long, Account> gameAccMap = new HashMap<>();
                    BattlenetAccount bnetAcc = (BattlenetAccount) rows.get(0).get("bnetAcc");
                    rows.forEach(allMap -> {
                        Account account = (Account) allMap.get("acc");
                        AccountLastPlayedCharacter alpc = (AccountLastPlayedCharacter) allMap.get("alpc");
                        Realmlist rl = (Realmlist) allMap.get("rl");
                        Realmcharacter rc = (Realmcharacter) allMap.get("rc");
                        if (alpc.getAccountId() != null) {
                            account.setAccountLastPlayedCharacter(alpc);
                        }
                        if (rc.getAcctid() != null) {
                            account.setRealmcharacter(rc);
                        }
                        account.setRealmlist(rl);
                        gameAccMap.put(account.getId(), account);
                    });
                    List<Account> collect = gameAccMap.values()
                            .stream()
                            .sorted(Comparator.comparing(Account::getId))
                            .collect(Collectors.toList());
                    bnetAcc.setGameAccounts(collect);
                    return bnetAcc;
                });
    }


    @Override
    public Mono<Account> queryAccountByRealmJoinTicket(long realmId, String realmJoinTicket) {
        return template.getDatabaseClient().sql(AuthSqlConstants.LOGIN_SEL_ACCOUNT_INFO_BY_NAME)
                .bind("realmID", realmId)
                .bind("userName", realmJoinTicket)
                .map(row -> {
                    BattlenetAccount bnetAcc = new BattlenetAccount();
                    Account acc = new Account();
                    bnetAcc.setId(row.get("ba_id", Long.class));
                    bnetAcc.setLocked(row.get("ba_locked", Integer.class));
                    bnetAcc.setLockCountry(row.get("ba_lock_country", String.class));
                    bnetAcc.setLastIp(row.get("ba_last_ip", String.class));
                    bnetAcc.setLocale(row.get("ba_locale", Integer.class));
                    bnetAcc.setBanned(row.get("ba_baned", Boolean.class));

                    acc.setId(row.get("acc_id", Long.class));
                    acc.setSessionKeyBnet(row.get("acc_session_key_bnet", byte[].class));
                    acc.setBattlenetAccount(row.get("ba_id", Long.class));
                    acc.setBanned(row.get("acc_banded", Boolean.class));
                    acc.setSecurityLevel(row.get("acc_security_level", Integer.class));
                    acc.setExpansion(row.get("acc_expansion", Integer.class));
                    acc.setOs(row.get("acc_os", String.class));
                    acc.setRecruiter(row.get("acc_recruiter", Long.class));
                    acc.setMutetime(row.get("acc_mutetime", Long.class));
                    acc.setBnetAcc(bnetAcc);
                    return acc;
                }).one();
    }


}
