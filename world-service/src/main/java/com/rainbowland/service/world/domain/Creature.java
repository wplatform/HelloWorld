package com.rainbowland.service.world.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("creature")
public class Creature {

    @Column("guid")
    private Long guid;
    @Column("id")
    private Integer id;
    @Column("map")
    private Integer map;
    @Column("zoneId")
    private Integer zoneId;
    @Column("areaId")
    private Integer areaId;
    @Column("spawnDifficulties")
    private String spawnDifficulties;
    @Column("phaseUseFlags")
    private Integer phaseUseFlags;
    @Column("PhaseId")
    private Integer phaseId;
    @Column("PhaseGroup")
    private Integer phaseGroup;
    @Column("terrainSwapMap")
    private Integer terrainSwapMap;
    @Column("modelid")
    private Integer modelid;
    @Column("equipment_id")
    private Integer equipmentId;
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("orientation")
    private Double orientation;
    @Column("spawntimesecs")
    private Integer spawntimesecs;
    @Column("spawndist")
    private Double spawndist;
    @Column("currentwaypoint")
    private Integer currentwaypoint;
    @Column("curhealth")
    private Integer curhealth;
    @Column("curmana")
    private Integer curmana;
    @Column("MovementType")
    private Integer movementType;
    @Column("npcflag")
    private Long npcflag;
    @Column("unit_flags")
    private Integer unitFlags;
    @Column("unit_flags2")
    private Integer unitFlags2;
    @Column("unit_flags3")
    private Integer unitFlags3;
    @Column("dynamicflags")
    private Integer dynamicflags;
    @Column("ScriptName")
    private String scriptName;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Creature> {

        public Creature convert(Row row) {
            Creature domain = new Creature();
            domain.setGuid(row.get("guid", Long.class));
            domain.setId(row.get("id", Integer.class));
            domain.setMap(row.get("map", Integer.class));
            domain.setZoneId(row.get("zoneId", Integer.class));
            domain.setAreaId(row.get("areaId", Integer.class));
            domain.setSpawnDifficulties(row.get("spawnDifficulties", String.class));
            domain.setPhaseUseFlags(row.get("phaseUseFlags", Integer.class));
            domain.setPhaseId(row.get("PhaseId", Integer.class));
            domain.setPhaseGroup(row.get("PhaseGroup", Integer.class));
            domain.setTerrainSwapMap(row.get("terrainSwapMap", Integer.class));
            domain.setModelid(row.get("modelid", Integer.class));
            domain.setEquipmentId(row.get("equipment_id", Integer.class));
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setOrientation(row.get("orientation", Double.class));
            domain.setSpawntimesecs(row.get("spawntimesecs", Integer.class));
            domain.setSpawndist(row.get("spawndist", Double.class));
            domain.setCurrentwaypoint(row.get("currentwaypoint", Integer.class));
            domain.setCurhealth(row.get("curhealth", Integer.class));
            domain.setCurmana(row.get("curmana", Integer.class));
            domain.setMovementType(row.get("MovementType", Integer.class));
            domain.setNpcflag(row.get("npcflag", Long.class));
            domain.setUnitFlags(row.get("unit_flags", Integer.class));
            domain.setUnitFlags2(row.get("unit_flags2", Integer.class));
            domain.setUnitFlags3(row.get("unit_flags3", Integer.class));
            domain.setDynamicflags(row.get("dynamicflags", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Creature, OutboundRow> {

        public OutboundRow convert(Creature source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getMap()).ifPresent(e -> row.put("map", Parameter.from(e)));
            Optional.ofNullable(source.getZoneId()).ifPresent(e -> row.put("zoneId", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId()).ifPresent(e -> row.put("areaId", Parameter.from(e)));
            Optional.ofNullable(source.getSpawnDifficulties()).ifPresent(e -> row.put("spawnDifficulties", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseUseFlags()).ifPresent(e -> row.put("phaseUseFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseId", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseGroup()).ifPresent(e -> row.put("PhaseGroup", Parameter.from(e)));
            Optional.ofNullable(source.getTerrainSwapMap()).ifPresent(e -> row.put("terrainSwapMap", Parameter.from(e)));
            Optional.ofNullable(source.getModelid()).ifPresent(e -> row.put("modelid", Parameter.from(e)));
            Optional.ofNullable(source.getEquipmentId()).ifPresent(e -> row.put("equipment_id", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            Optional.ofNullable(source.getSpawntimesecs()).ifPresent(e -> row.put("spawntimesecs", Parameter.from(e)));
            Optional.ofNullable(source.getSpawndist()).ifPresent(e -> row.put("spawndist", Parameter.from(e)));
            Optional.ofNullable(source.getCurrentwaypoint()).ifPresent(e -> row.put("currentwaypoint", Parameter.from(e)));
            Optional.ofNullable(source.getCurhealth()).ifPresent(e -> row.put("curhealth", Parameter.from(e)));
            Optional.ofNullable(source.getCurmana()).ifPresent(e -> row.put("curmana", Parameter.from(e)));
            Optional.ofNullable(source.getMovementType()).ifPresent(e -> row.put("MovementType", Parameter.from(e)));
            Optional.ofNullable(source.getNpcflag()).ifPresent(e -> row.put("npcflag", Parameter.from(e)));
            Optional.ofNullable(source.getUnitFlags()).ifPresent(e -> row.put("unit_flags", Parameter.from(e)));
            Optional.ofNullable(source.getUnitFlags2()).ifPresent(e -> row.put("unit_flags2", Parameter.from(e)));
            Optional.ofNullable(source.getUnitFlags3()).ifPresent(e -> row.put("unit_flags3", Parameter.from(e)));
            Optional.ofNullable(source.getDynamicflags()).ifPresent(e -> row.put("dynamicflags", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
