package com.github.azeroth.game.service.repository;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AreaTriggerRepository {

    @Query("SELECT entry, ScriptName FROM areatrigger_scripts")
    Stream<Object[]> streamAllAreaTriggerScripts();
}
