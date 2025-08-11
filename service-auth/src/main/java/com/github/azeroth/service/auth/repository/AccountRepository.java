package com.github.azeroth.service.auth.repository;

import com.github.azeroth.service.auth.domain.Account;
import com.github.azeroth.service.auth.domain.AccountBanned;
import com.github.azeroth.service.auth.domain.AccountLastPlayedCharacter;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface AccountRepository extends CrudRepository<Account, Long> {


    @Query("from AccountBanned as a where a.id.id=:accountId and a.active = 1")
    List<AccountBanned> findBannedByAccountId(@Param("accountId") Long accountId);

    @Query("from AccountLastPlayedCharacter a where a.id.accountId in(:accountIds)")
    List<AccountLastPlayedCharacter> findLastPlayedCharacterByIdAccountIds(Set<Long> accountIds);


    @Query("""
            SELECT rc, r
            FROM Realmcharacter rc INNER JOIN Realmlist r ON rc.id.realmid = r.id
            WHERE rc.id.acctid in (:acctids)
            """)
    Object[][] findByIdAccounts(Set<Long> accounts);
}