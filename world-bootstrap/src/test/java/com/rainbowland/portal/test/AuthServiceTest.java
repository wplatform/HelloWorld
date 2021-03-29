package com.rainbowland.portal.test;

import com.rainbowland.bootstrap.portal.PortalApplication;
import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.auth.domain.Account;
import com.rainbowland.service.auth.domain.AccountAccess;
import com.rainbowland.service.auth.domain.BattlenetAccount;
import com.rainbowland.utils.SecureUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PortalApplication.class})
@ActiveProfiles("test")
public class AuthServiceTest {



    @Autowired
    AuthService service;

    @Test
    void testInsertAccount() {
        BattlenetAccount account = new BattlenetAccount();
        account.setEmail("test@test.com");
        account.setMobilePhone("18611111111");
        account.setJoindate(LocalDateTime.now());
        account.setShaPassHash(SecureUtils.passwordHash(account.getEmail(), "test"));
        account.setFailedLogins(0);
        account.setLoginTicket("543e32f32e23ab32c");
        account.setLocale(16);
        account.setOs("Wn64");

        service.insert(account).flatMapMany(ba -> {
            Account acc1 = new Account();
            acc1.setBattlenetAccount(ba.getId());
            acc1.setUsername("WoW#1");
            acc1.setOnline(0);
            acc1.setJoindate(LocalDateTime.now());

            Account acc2 = new Account();
            acc2.setBattlenetAccount(ba.getId());
            acc2.setUsername("WoW#2");
            acc2.setOnline(0);
            acc2.setJoindate(LocalDateTime.now());

            return Flux.just(acc1, acc2).flatMap(service::insert).flatMap(e -> {
                AccountAccess aa = new AccountAccess();
                aa.setAccountId(e.getId());
                aa.setSecurityLevel(3);
                aa.setRealmId(1);
                return service.insert(aa);
            });
        }).subscribe(accountAccess -> {
            service.queryBattleNetAccountByLoginTicket(account.getLoginTicket()).subscribe(selected -> {
                Assertions.assertTrue(selected.getId() == account.getId());
            });
        });

    }

}
