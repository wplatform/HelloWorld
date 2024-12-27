package com.github.mmo.service.auth.repository;

import com.github.mmo.service.auth.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}