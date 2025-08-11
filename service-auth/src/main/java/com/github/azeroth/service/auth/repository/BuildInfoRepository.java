package com.github.azeroth.service.auth.repository;


import com.github.azeroth.service.auth.domain.BuildInfo;
import org.springframework.data.jdbc.repository.query.Query;


import java.util.stream.Stream;

public interface BuildInfoRepository {
    @Query("select a, b from BuildInfo a inner join BuildAuthKey b on a.id = b.id.build")
    Stream<View> stream();

    record View(BuildInfo buildInfo, BuildAuthKey authKey) {};
}