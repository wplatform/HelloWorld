package com.github.azeroth.service.auth.repository;

import com.github.azeroth.service.auth.domain.BattlenetAccount;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface BattlenetAccountRepository extends CrudRepository<BattlenetAccount, Long> {

    @Query("FROM BattlenetAccount a LEFT JOIN FETCH a.accounts b WHERE a.loginTicket = :loginTicket")
    Optional<BattlenetAccount> queryByLoginTicket(@Param("loginTicket") String loginTicket);

}