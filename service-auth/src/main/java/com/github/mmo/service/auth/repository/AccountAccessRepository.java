package com.github.mmo.service.auth.repository;

import com.github.mmo.service.auth.domain.AccountAccess;
import com.github.mmo.service.auth.domain.AccountAccessId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountAccessRepository extends JpaRepository<AccountAccess, AccountAccessId> {
}