package com.github.azeroth.game.service.repository;


import com.github.azeroth.game.domain.areatrigger.AreaTriggerAction;
import com.github.azeroth.game.domain.areatrigger.AreaTriggerTemplate;
import com.github.azeroth.game.domain.areatrigger.AreaTriggerTeleport;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AreaTriggerRepository {

    @Query("SELECT AreaTriggerId, IsCustom, ActionType, ActionParam, TargetType FROM `areatrigger_template_actions`")
    Stream<AreaTriggerAction> streamAllAreaTriggerTemplateActions();

    @Query("SELECT AreaTriggerCreatePropertiesId, IsCustom, Idx, VerticeX, VerticeY, VerticeTargetX, VerticeTargetY FROM `areatrigger_create_properties_polygon_vertex` ORDER BY `AreaTriggerCreatePropertiesId`, `IsCustom`, `Idx`")
    Stream<Object[]> streamAllAreaTriggerCreatePropertiesPolygonVertex();
    @Query("SELECT AreaTriggerCreatePropertiesId, IsCustom, X, Y, Z FROM `areatrigger_create_properties_spline_point` ORDER BY `AreaTriggerCreatePropertiesId`, `IsCustom`, `Idx`")
    Stream<Object[]> streamAllAreaTriggerCreatePropertiesSplinePoint();
    @Query("SELECT Id, IsCustom, Flags, ActionSetId, ActionSetFlags FROM `areatrigger_template`")
    Stream<AreaTriggerTemplate> streamAllAreaTriggerTemplate();

    @Query("SELECT entry, ScriptName FROM areatrigger_scripts")
    Stream<Object[]> streamAllAreaTriggerScripts();

    @Query("SELECT ID, PortLocID FROM areatrigger_teleport")
    Stream<AreaTriggerTeleport> streamAllAreaTriggerTeleport();
}
