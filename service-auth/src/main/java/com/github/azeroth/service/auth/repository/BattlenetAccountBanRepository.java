package com.github.azeroth.service.auth.repository;

import com.github.azeroth.service.auth.domain.BattlenetAccountBan;
import com.github.azeroth.service.auth.domain.BattlenetAccountBanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.List;

public interface BattlenetAccountBanRepository extends JpaRepository<BattlenetAccountBan, BattlenetAccountBanId> {

    @Query("from BattlenetAccountBan b where b.id.id = :accountId")
    List<BattlenetAccountBan> findByAccount(Long accountId);
}