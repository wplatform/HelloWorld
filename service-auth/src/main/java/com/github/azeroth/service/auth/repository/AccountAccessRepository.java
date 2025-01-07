package com.github.azeroth.service.auth.repository;

import com.github.azeroth.service.auth.domain.AccountAccess;
import com.github.azeroth.service.auth.domain.AccountAccessId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountAccessRepository extends JpaRepository<AccountAccess, AccountAccessId> {
}