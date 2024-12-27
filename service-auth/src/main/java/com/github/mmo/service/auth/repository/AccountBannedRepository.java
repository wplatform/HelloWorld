package com.github.mmo.service.auth.repository;

import com.github.mmo.service.auth.domain.AccountBanned;
import com.github.mmo.service.auth.domain.AccountBannedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountBannedRepository extends JpaRepository<AccountBanned, AccountBannedId> {

    @Query("from AccountBanned as a where a.id.id=:accountId and a.active = 1")
    List<AccountBanned> findByAccountId(@Param("accountId") Long accountId);
}