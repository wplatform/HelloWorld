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
@Table("map")
public class Map {

    @Column("ID")
    private Integer id;
    @Column("Directory")
    private String directory;
    @Column("MapName")
    private String mapName;
    @Column("InternalName")
    private String internalName;
    @Column("MapDescription0")
    private String mapDescription0;
    @Column("MapDescription1")
    private String mapDescription1;
    @Column("PvpShortDescription")
    private String pvpShortDescription;
    @Column("PvpLongDescription")
    private String pvpLongDescription;
    @Column("CorpseX")
    private Double corpseX;
    @Column("CorpseY")
    private Double corpseY;
    @Column("MapType")
    private Integer mapType;
    @Column("InstanceType")
    private Integer instanceType;
    @Column("ExpansionID")
    private Integer expansionId;
    @Column("AreaTableID")
    private Integer areaTableId;
    @Column("LoadingScreenID")
    private Integer loadingScreenId;
    @Column("TimeOfDayOverride")
    private Integer timeOfDayOverride;
    @Column("ParentMapID")
    private Integer parentMapId;
    @Column("CosmeticParentMapID")
    private Integer cosmeticParentMapId;
    @Column("TimeOffset")
    private Integer timeOffset;
    @Column("MinimapIconScale")
    private Double minimapIconScale;
    @Column("CorpseMapID")
    private Integer corpseMapId;
    @Column("MaxPlayers")
    private Integer maxPlayers;
    @Column("WindSettingsID")
    private Integer windSettingsId;
    @Column("ZmpFileDataID")
    private Integer zmpFileDataId;
    @Column("WdtFileDataID")
    private Integer wdtFileDataId;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Map> {

        public Map convert(Row row) {
            Map domain = new Map();
            domain.setId(row.get("ID", Integer.class));
            domain.setDirectory(row.get("Directory", String.class));
            domain.setMapName(row.get("MapName", String.class));
            domain.setInternalName(row.get("InternalName", String.class));
            domain.setMapDescription0(row.get("MapDescription0", String.class));
            domain.setMapDescription1(row.get("MapDescription1", String.class));
            domain.setPvpShortDescription(row.get("PvpShortDescription", String.class));
            domain.setPvpLongDescription(row.get("PvpLongDescription", String.class));
            domain.setCorpseX(row.get("CorpseX", Double.class));
            domain.setCorpseY(row.get("CorpseY", Double.class));
            domain.setMapType(row.get("MapType", Integer.class));
            domain.setInstanceType(row.get("InstanceType", Integer.class));
            domain.setExpansionId(row.get("ExpansionID", Integer.class));
            domain.setAreaTableId(row.get("AreaTableID", Integer.class));
            domain.setLoadingScreenId(row.get("LoadingScreenID", Integer.class));
            domain.setTimeOfDayOverride(row.get("TimeOfDayOverride", Integer.class));
            domain.setParentMapId(row.get("ParentMapID", Integer.class));
            domain.setCosmeticParentMapId(row.get("CosmeticParentMapID", Integer.class));
            domain.setTimeOffset(row.get("TimeOffset", Integer.class));
            domain.setMinimapIconScale(row.get("MinimapIconScale", Double.class));
            domain.setCorpseMapId(row.get("CorpseMapID", Integer.class));
            domain.setMaxPlayers(row.get("MaxPlayers", Integer.class));
            domain.setWindSettingsId(row.get("WindSettingsID", Integer.class));
            domain.setZmpFileDataId(row.get("ZmpFileDataID", Integer.class));
            domain.setWdtFileDataId(row.get("WdtFileDataID", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Map, OutboundRow> {

        public OutboundRow convert(Map source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDirectory()).ifPresent(e -> row.put("Directory", Parameter.from(e)));
            Optional.ofNullable(source.getMapName()).ifPresent(e -> row.put("MapName", Parameter.from(e)));
            Optional.ofNullable(source.getInternalName()).ifPresent(e -> row.put("InternalName", Parameter.from(e)));
            Optional.ofNullable(source.getMapDescription0()).ifPresent(e -> row.put("MapDescription0", Parameter.from(e)));
            Optional.ofNullable(source.getMapDescription1()).ifPresent(e -> row.put("MapDescription1", Parameter.from(e)));
            Optional.ofNullable(source.getPvpShortDescription()).ifPresent(e -> row.put("PvpShortDescription", Parameter.from(e)));
            Optional.ofNullable(source.getPvpLongDescription()).ifPresent(e -> row.put("PvpLongDescription", Parameter.from(e)));
            Optional.ofNullable(source.getCorpseX()).ifPresent(e -> row.put("CorpseX", Parameter.from(e)));
            Optional.ofNullable(source.getCorpseY()).ifPresent(e -> row.put("CorpseY", Parameter.from(e)));
            Optional.ofNullable(source.getMapType()).ifPresent(e -> row.put("MapType", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceType()).ifPresent(e -> row.put("InstanceType", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionId()).ifPresent(e -> row.put("ExpansionID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaTableId()).ifPresent(e -> row.put("AreaTableID", Parameter.from(e)));
            Optional.ofNullable(source.getLoadingScreenId()).ifPresent(e -> row.put("LoadingScreenID", Parameter.from(e)));
            Optional.ofNullable(source.getTimeOfDayOverride()).ifPresent(e -> row.put("TimeOfDayOverride", Parameter.from(e)));
            Optional.ofNullable(source.getParentMapId()).ifPresent(e -> row.put("ParentMapID", Parameter.from(e)));
            Optional.ofNullable(source.getCosmeticParentMapId()).ifPresent(e -> row.put("CosmeticParentMapID", Parameter.from(e)));
            Optional.ofNullable(source.getTimeOffset()).ifPresent(e -> row.put("TimeOffset", Parameter.from(e)));
            Optional.ofNullable(source.getMinimapIconScale()).ifPresent(e -> row.put("MinimapIconScale", Parameter.from(e)));
            Optional.ofNullable(source.getCorpseMapId()).ifPresent(e -> row.put("CorpseMapID", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPlayers()).ifPresent(e -> row.put("MaxPlayers", Parameter.from(e)));
            Optional.ofNullable(source.getWindSettingsId()).ifPresent(e -> row.put("WindSettingsID", Parameter.from(e)));
            Optional.ofNullable(source.getZmpFileDataId()).ifPresent(e -> row.put("ZmpFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getWdtFileDataId()).ifPresent(e -> row.put("WdtFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
