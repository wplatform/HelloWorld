package com.github.azeroth.service.auth.repository;

import com.github.azeroth.service.auth.domain.BuildAuthKey;
import com.github.azeroth.service.auth.domain.BuildInfo;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.stream.Stream;

public interface BuildInfoRepository extends JpaRepository<BuildInfo, Integer> {
    @QueryHints(value = @QueryHint(name = HibernateHints.HINT_FETCH_SIZE, value = "25"))
    @Query("select a, b from BuildInfo a inner join BuildAuthKey b on a.id = b.id.build")
    Stream<View> stream();

    record View(BuildInfo buildInfo, BuildAuthKey authKey) {};
}