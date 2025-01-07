package com.github.azeroth.service.auth.repository;

import com.github.azeroth.service.auth.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}