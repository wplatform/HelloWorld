package com.github.azeroth.service.auth.repository;

import com.github.azeroth.service.auth.domain.AccountLastPlayedCharacter;
import com.github.azeroth.service.auth.domain.AccountLastPlayedCharacterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.List;
import java.util.Set;

public interface AccountLastPlayedCharacterRepository extends JpaRepository<AccountLastPlayedCharacter, AccountLastPlayedCharacterId> {
    @Query("from AccountLastPlayedCharacter a where a.id.accountId in(:accountIds)")
    List<AccountLastPlayedCharacter> findByIdAccountIds(Set<Long> accountIds);
}