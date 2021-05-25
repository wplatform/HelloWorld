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
@Table("battlemaster_list")
public class BattlemasterList {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("GameType")
    private String gameType;
    @Column("ShortDescription")
    private String shortDescription;
    @Column("LongDescription")
    private String longDescription;
    @Column("InstanceType")
    private Integer instanceType;
    @Column("MinLevel")
    private Integer minLevel;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("RatedPlayers")
    private Integer ratedPlayers;
    @Column("MinPlayers")
    private Integer minPlayers;
    @Column("MaxPlayers")
    private Integer maxPlayers;
    @Column("GroupsAllowed")
    private Integer groupsAllowed;
    @Column("MaxGroupSize")
    private Integer maxGroupSize;
    @Column("HolidayWorldState")
    private Integer holidayWorldState;
    @Column("Flags")
    private Integer flags;
    @Column("IconFileDataID")
    private Integer iconFileDataId;
    @Column("RequiredPlayerConditionID")
    private Integer requiredPlayerConditionId;
    @Column("MapID1")
    private Integer mapId1;
    @Column("MapID2")
    private Integer mapId2;
    @Column("MapID3")
    private Integer mapId3;
    @Column("MapID4")
    private Integer mapId4;
    @Column("MapID5")
    private Integer mapId5;
    @Column("MapID6")
    private Integer mapId6;
    @Column("MapID7")
    private Integer mapId7;
    @Column("MapID8")
    private Integer mapId8;
    @Column("MapID9")
    private Integer mapId9;
    @Column("MapID10")
    private Integer mapId10;
    @Column("MapID11")
    private Integer mapId11;
    @Column("MapID12")
    private Integer mapId12;
    @Column("MapID13")
    private Integer mapId13;
    @Column("MapID14")
    private Integer mapId14;
    @Column("MapID15")
    private Integer mapId15;
    @Column("MapID16")
    private Integer mapId16;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlemasterList> {

        public BattlemasterList convert(Row row) {
            BattlemasterList domain = new BattlemasterList();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setGameType(row.get("GameType", String.class));
            domain.setShortDescription(row.get("ShortDescription", String.class));
            domain.setLongDescription(row.get("LongDescription", String.class));
            domain.setInstanceType(row.get("InstanceType", Integer.class));
            domain.setMinLevel(row.get("MinLevel", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setRatedPlayers(row.get("RatedPlayers", Integer.class));
            domain.setMinPlayers(row.get("MinPlayers", Integer.class));
            domain.setMaxPlayers(row.get("MaxPlayers", Integer.class));
            domain.setGroupsAllowed(row.get("GroupsAllowed", Integer.class));
            domain.setMaxGroupSize(row.get("MaxGroupSize", Integer.class));
            domain.setHolidayWorldState(row.get("HolidayWorldState", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setIconFileDataId(row.get("IconFileDataID", Integer.class));
            domain.setRequiredPlayerConditionId(row.get("RequiredPlayerConditionID", Integer.class));
            domain.setMapId1(row.get("MapID1", Integer.class));
            domain.setMapId2(row.get("MapID2", Integer.class));
            domain.setMapId3(row.get("MapID3", Integer.class));
            domain.setMapId4(row.get("MapID4", Integer.class));
            domain.setMapId5(row.get("MapID5", Integer.class));
            domain.setMapId6(row.get("MapID6", Integer.class));
            domain.setMapId7(row.get("MapID7", Integer.class));
            domain.setMapId8(row.get("MapID8", Integer.class));
            domain.setMapId9(row.get("MapID9", Integer.class));
            domain.setMapId10(row.get("MapID10", Integer.class));
            domain.setMapId11(row.get("MapID11", Integer.class));
            domain.setMapId12(row.get("MapID12", Integer.class));
            domain.setMapId13(row.get("MapID13", Integer.class));
            domain.setMapId14(row.get("MapID14", Integer.class));
            domain.setMapId15(row.get("MapID15", Integer.class));
            domain.setMapId16(row.get("MapID16", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlemasterList, OutboundRow> {

        public OutboundRow convert(BattlemasterList source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getGameType()).ifPresent(e -> row.put("GameType", Parameter.from(e)));
            Optional.ofNullable(source.getShortDescription()).ifPresent(e -> row.put("ShortDescription", Parameter.from(e)));
            Optional.ofNullable(source.getLongDescription()).ifPresent(e -> row.put("LongDescription", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceType()).ifPresent(e -> row.put("InstanceType", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevel()).ifPresent(e -> row.put("MinLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getRatedPlayers()).ifPresent(e -> row.put("RatedPlayers", Parameter.from(e)));
            Optional.ofNullable(source.getMinPlayers()).ifPresent(e -> row.put("MinPlayers", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPlayers()).ifPresent(e -> row.put("MaxPlayers", Parameter.from(e)));
            Optional.ofNullable(source.getGroupsAllowed()).ifPresent(e -> row.put("GroupsAllowed", Parameter.from(e)));
            Optional.ofNullable(source.getMaxGroupSize()).ifPresent(e -> row.put("MaxGroupSize", Parameter.from(e)));
            Optional.ofNullable(source.getHolidayWorldState()).ifPresent(e -> row.put("HolidayWorldState", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileDataId()).ifPresent(e -> row.put("IconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredPlayerConditionId()).ifPresent(e -> row.put("RequiredPlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getMapId1()).ifPresent(e -> row.put("MapID1", Parameter.from(e)));
            Optional.ofNullable(source.getMapId2()).ifPresent(e -> row.put("MapID2", Parameter.from(e)));
            Optional.ofNullable(source.getMapId3()).ifPresent(e -> row.put("MapID3", Parameter.from(e)));
            Optional.ofNullable(source.getMapId4()).ifPresent(e -> row.put("MapID4", Parameter.from(e)));
            Optional.ofNullable(source.getMapId5()).ifPresent(e -> row.put("MapID5", Parameter.from(e)));
            Optional.ofNullable(source.getMapId6()).ifPresent(e -> row.put("MapID6", Parameter.from(e)));
            Optional.ofNullable(source.getMapId7()).ifPresent(e -> row.put("MapID7", Parameter.from(e)));
            Optional.ofNullable(source.getMapId8()).ifPresent(e -> row.put("MapID8", Parameter.from(e)));
            Optional.ofNullable(source.getMapId9()).ifPresent(e -> row.put("MapID9", Parameter.from(e)));
            Optional.ofNullable(source.getMapId10()).ifPresent(e -> row.put("MapID10", Parameter.from(e)));
            Optional.ofNullable(source.getMapId11()).ifPresent(e -> row.put("MapID11", Parameter.from(e)));
            Optional.ofNullable(source.getMapId12()).ifPresent(e -> row.put("MapID12", Parameter.from(e)));
            Optional.ofNullable(source.getMapId13()).ifPresent(e -> row.put("MapID13", Parameter.from(e)));
            Optional.ofNullable(source.getMapId14()).ifPresent(e -> row.put("MapID14", Parameter.from(e)));
            Optional.ofNullable(source.getMapId15()).ifPresent(e -> row.put("MapID15", Parameter.from(e)));
            Optional.ofNullable(source.getMapId16()).ifPresent(e -> row.put("MapID16", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
