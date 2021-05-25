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
@Table("gameobject")
public class Gameobject {

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
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("orientation")
    private Double orientation;
    @Column("rotation0")
    private Double rotation0;
    @Column("rotation1")
    private Double rotation1;
    @Column("rotation2")
    private Double rotation2;
    @Column("rotation3")
    private Double rotation3;
    @Column("spawntimesecs")
    private Integer spawntimesecs;
    @Column("animprogress")
    private Integer animprogress;
    @Column("state")
    private Integer state;
    @Column("ScriptName")
    private String scriptName;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Gameobject> {

        public Gameobject convert(Row row) {
            Gameobject domain = new Gameobject();
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
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setOrientation(row.get("orientation", Double.class));
            domain.setRotation0(row.get("rotation0", Double.class));
            domain.setRotation1(row.get("rotation1", Double.class));
            domain.setRotation2(row.get("rotation2", Double.class));
            domain.setRotation3(row.get("rotation3", Double.class));
            domain.setSpawntimesecs(row.get("spawntimesecs", Integer.class));
            domain.setAnimprogress(row.get("animprogress", Integer.class));
            domain.setState(row.get("state", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Gameobject, OutboundRow> {

        public OutboundRow convert(Gameobject source) {
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
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            Optional.ofNullable(source.getRotation0()).ifPresent(e -> row.put("rotation0", Parameter.from(e)));
            Optional.ofNullable(source.getRotation1()).ifPresent(e -> row.put("rotation1", Parameter.from(e)));
            Optional.ofNullable(source.getRotation2()).ifPresent(e -> row.put("rotation2", Parameter.from(e)));
            Optional.ofNullable(source.getRotation3()).ifPresent(e -> row.put("rotation3", Parameter.from(e)));
            Optional.ofNullable(source.getSpawntimesecs()).ifPresent(e -> row.put("spawntimesecs", Parameter.from(e)));
            Optional.ofNullable(source.getAnimprogress()).ifPresent(e -> row.put("animprogress", Parameter.from(e)));
            Optional.ofNullable(source.getState()).ifPresent(e -> row.put("state", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
