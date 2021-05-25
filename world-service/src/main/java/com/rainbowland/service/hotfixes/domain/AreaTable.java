package com.rainbowland.service.hotfixes.domain;

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
@Table("area_table")
public class AreaTable {

    @Column("ID")
    private Integer id;
    @Column("ZoneName")
    private String zoneName;
    @Column("AreaName")
    private String areaName;
    @Column("ContinentID")
    private Integer continentId;
    @Column("ParentAreaID")
    private Integer parentAreaId;
    @Column("AreaBit")
    private Integer areaBit;
    @Column("SoundProviderPref")
    private Integer soundProviderPref;
    @Column("SoundProviderPrefUnderwater")
    private Integer soundProviderPrefUnderwater;
    @Column("AmbienceID")
    private Integer ambienceId;
    @Column("UwAmbience")
    private Integer uwAmbience;
    @Column("ZoneMusic")
    private Integer zoneMusic;
    @Column("UwZoneMusic")
    private Integer uwZoneMusic;
    @Column("IntroSound")
    private Integer introSound;
    @Column("UwIntroSound")
    private Integer uwIntroSound;
    @Column("FactionGroupMask")
    private Integer factionGroupMask;
    @Column("AmbientMultiplier")
    private Double ambientMultiplier;
    @Column("MountFlags")
    private Integer mountFlags;
    @Column("PvpCombatWorldStateID")
    private Integer pvpCombatWorldStateId;
    @Column("WildBattlePetLevelMin")
    private Integer wildBattlePetLevelMin;
    @Column("WildBattlePetLevelMax")
    private Integer wildBattlePetLevelMax;
    @Column("WindSettingsID")
    private Integer windSettingsId;
    @Column("ContentTuningID")
    private Integer contentTuningId;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("LiquidTypeID1")
    private Integer liquidTypeId1;
    @Column("LiquidTypeID2")
    private Integer liquidTypeId2;
    @Column("LiquidTypeID3")
    private Integer liquidTypeId3;
    @Column("LiquidTypeID4")
    private Integer liquidTypeId4;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreaTable> {

        public AreaTable convert(Row row) {
            AreaTable domain = new AreaTable();
            domain.setId(row.get("ID", Integer.class));
            domain.setZoneName(row.get("ZoneName", String.class));
            domain.setAreaName(row.get("AreaName", String.class));
            domain.setContinentId(row.get("ContinentID", Integer.class));
            domain.setParentAreaId(row.get("ParentAreaID", Integer.class));
            domain.setAreaBit(row.get("AreaBit", Integer.class));
            domain.setSoundProviderPref(row.get("SoundProviderPref", Integer.class));
            domain.setSoundProviderPrefUnderwater(row.get("SoundProviderPrefUnderwater", Integer.class));
            domain.setAmbienceId(row.get("AmbienceID", Integer.class));
            domain.setUwAmbience(row.get("UwAmbience", Integer.class));
            domain.setZoneMusic(row.get("ZoneMusic", Integer.class));
            domain.setUwZoneMusic(row.get("UwZoneMusic", Integer.class));
            domain.setIntroSound(row.get("IntroSound", Integer.class));
            domain.setUwIntroSound(row.get("UwIntroSound", Integer.class));
            domain.setFactionGroupMask(row.get("FactionGroupMask", Integer.class));
            domain.setAmbientMultiplier(row.get("AmbientMultiplier", Double.class));
            domain.setMountFlags(row.get("MountFlags", Integer.class));
            domain.setPvpCombatWorldStateId(row.get("PvpCombatWorldStateID", Integer.class));
            domain.setWildBattlePetLevelMin(row.get("WildBattlePetLevelMin", Integer.class));
            domain.setWildBattlePetLevelMax(row.get("WildBattlePetLevelMax", Integer.class));
            domain.setWindSettingsId(row.get("WindSettingsID", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningID", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setLiquidTypeId1(row.get("LiquidTypeID1", Integer.class));
            domain.setLiquidTypeId2(row.get("LiquidTypeID2", Integer.class));
            domain.setLiquidTypeId3(row.get("LiquidTypeID3", Integer.class));
            domain.setLiquidTypeId4(row.get("LiquidTypeID4", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreaTable, OutboundRow> {

        public OutboundRow convert(AreaTable source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getZoneName()).ifPresent(e -> row.put("ZoneName", Parameter.from(e)));
            Optional.ofNullable(source.getAreaName()).ifPresent(e -> row.put("AreaName", Parameter.from(e)));
            Optional.ofNullable(source.getContinentId()).ifPresent(e -> row.put("ContinentID", Parameter.from(e)));
            Optional.ofNullable(source.getParentAreaId()).ifPresent(e -> row.put("ParentAreaID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaBit()).ifPresent(e -> row.put("AreaBit", Parameter.from(e)));
            Optional.ofNullable(source.getSoundProviderPref()).ifPresent(e -> row.put("SoundProviderPref", Parameter.from(e)));
            Optional.ofNullable(source.getSoundProviderPrefUnderwater()).ifPresent(e -> row.put("SoundProviderPrefUnderwater", Parameter.from(e)));
            Optional.ofNullable(source.getAmbienceId()).ifPresent(e -> row.put("AmbienceID", Parameter.from(e)));
            Optional.ofNullable(source.getUwAmbience()).ifPresent(e -> row.put("UwAmbience", Parameter.from(e)));
            Optional.ofNullable(source.getZoneMusic()).ifPresent(e -> row.put("ZoneMusic", Parameter.from(e)));
            Optional.ofNullable(source.getUwZoneMusic()).ifPresent(e -> row.put("UwZoneMusic", Parameter.from(e)));
            Optional.ofNullable(source.getIntroSound()).ifPresent(e -> row.put("IntroSound", Parameter.from(e)));
            Optional.ofNullable(source.getUwIntroSound()).ifPresent(e -> row.put("UwIntroSound", Parameter.from(e)));
            Optional.ofNullable(source.getFactionGroupMask()).ifPresent(e -> row.put("FactionGroupMask", Parameter.from(e)));
            Optional.ofNullable(source.getAmbientMultiplier()).ifPresent(e -> row.put("AmbientMultiplier", Parameter.from(e)));
            Optional.ofNullable(source.getMountFlags()).ifPresent(e -> row.put("MountFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPvpCombatWorldStateId()).ifPresent(e -> row.put("PvpCombatWorldStateID", Parameter.from(e)));
            Optional.ofNullable(source.getWildBattlePetLevelMin()).ifPresent(e -> row.put("WildBattlePetLevelMin", Parameter.from(e)));
            Optional.ofNullable(source.getWildBattlePetLevelMax()).ifPresent(e -> row.put("WildBattlePetLevelMax", Parameter.from(e)));
            Optional.ofNullable(source.getWindSettingsId()).ifPresent(e -> row.put("WindSettingsID", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getLiquidTypeId1()).ifPresent(e -> row.put("LiquidTypeID1", Parameter.from(e)));
            Optional.ofNullable(source.getLiquidTypeId2()).ifPresent(e -> row.put("LiquidTypeID2", Parameter.from(e)));
            Optional.ofNullable(source.getLiquidTypeId3()).ifPresent(e -> row.put("LiquidTypeID3", Parameter.from(e)));
            Optional.ofNullable(source.getLiquidTypeId4()).ifPresent(e -> row.put("LiquidTypeID4", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
