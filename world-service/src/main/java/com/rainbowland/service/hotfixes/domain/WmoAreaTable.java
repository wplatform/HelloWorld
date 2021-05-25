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
@Table("wmo_area_table")
public class WmoAreaTable {

    @Column("AreaName")
    private String areaName;
    @Column("ID")
    private Integer id;
    @Column("WmoID")
    private Integer wmoId;
    @Column("NameSetID")
    private Integer nameSetId;
    @Column("WmoGroupID")
    private Integer wmoGroupId;
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
    @Column("AreaTableID")
    private Integer areaTableId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, WmoAreaTable> {

        public WmoAreaTable convert(Row row) {
            WmoAreaTable domain = new WmoAreaTable();
            domain.setAreaName(row.get("AreaName", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setWmoId(row.get("WmoID", Integer.class));
            domain.setNameSetId(row.get("NameSetID", Integer.class));
            domain.setWmoGroupId(row.get("WmoGroupID", Integer.class));
            domain.setSoundProviderPref(row.get("SoundProviderPref", Integer.class));
            domain.setSoundProviderPrefUnderwater(row.get("SoundProviderPrefUnderwater", Integer.class));
            domain.setAmbienceId(row.get("AmbienceID", Integer.class));
            domain.setUwAmbience(row.get("UwAmbience", Integer.class));
            domain.setZoneMusic(row.get("ZoneMusic", Integer.class));
            domain.setUwZoneMusic(row.get("UwZoneMusic", Integer.class));
            domain.setIntroSound(row.get("IntroSound", Integer.class));
            domain.setUwIntroSound(row.get("UwIntroSound", Integer.class));
            domain.setAreaTableId(row.get("AreaTableID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<WmoAreaTable, OutboundRow> {

        public OutboundRow convert(WmoAreaTable source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAreaName()).ifPresent(e -> row.put("AreaName", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getWmoId()).ifPresent(e -> row.put("WmoID", Parameter.from(e)));
            Optional.ofNullable(source.getNameSetId()).ifPresent(e -> row.put("NameSetID", Parameter.from(e)));
            Optional.ofNullable(source.getWmoGroupId()).ifPresent(e -> row.put("WmoGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getSoundProviderPref()).ifPresent(e -> row.put("SoundProviderPref", Parameter.from(e)));
            Optional.ofNullable(source.getSoundProviderPrefUnderwater()).ifPresent(e -> row.put("SoundProviderPrefUnderwater", Parameter.from(e)));
            Optional.ofNullable(source.getAmbienceId()).ifPresent(e -> row.put("AmbienceID", Parameter.from(e)));
            Optional.ofNullable(source.getUwAmbience()).ifPresent(e -> row.put("UwAmbience", Parameter.from(e)));
            Optional.ofNullable(source.getZoneMusic()).ifPresent(e -> row.put("ZoneMusic", Parameter.from(e)));
            Optional.ofNullable(source.getUwZoneMusic()).ifPresent(e -> row.put("UwZoneMusic", Parameter.from(e)));
            Optional.ofNullable(source.getIntroSound()).ifPresent(e -> row.put("IntroSound", Parameter.from(e)));
            Optional.ofNullable(source.getUwIntroSound()).ifPresent(e -> row.put("UwIntroSound", Parameter.from(e)));
            Optional.ofNullable(source.getAreaTableId()).ifPresent(e -> row.put("AreaTableID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
