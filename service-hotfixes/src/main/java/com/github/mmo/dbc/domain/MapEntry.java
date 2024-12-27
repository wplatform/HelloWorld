package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.EnumFlag;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2Type;
import com.github.mmo.dbc.defines.MapFlag;
import com.github.mmo.dbc.defines.MapFlag2;
import com.github.mmo.dbc.defines.MapTypes;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "map")
@Db2DataBind(name = "Map.db2", layoutHash = 0xF568DF12, fields = {
        @Db2Field(name = "directory", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "mapName", type = Db2Type.STRING),
        @Db2Field(name = {"mapDescription0", "mapDescription1"}, type = Db2Type.STRING),
        @Db2Field(name = "pvpShortDescription", type = Db2Type.STRING),
        @Db2Field(name = "pvpLongDescription", type = Db2Type.STRING),
        @Db2Field(name = {"flags1", "flags2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "minimapIconScale", type = Db2Type.FLOAT),
        @Db2Field(name = "corpseX", type = Db2Type.FLOAT),
        @Db2Field(name = "corpseY", type = Db2Type.FLOAT),
        @Db2Field(name = "areaTableID", type = Db2Type.SHORT),
        @Db2Field(name = "loadingScreenID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "corpseMapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "timeOfDayOverride", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "parentMapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "cosmeticParentMapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "windSettingsID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "instanceType", type = Db2Type.BYTE),
        @Db2Field(name = "mapType", type = Db2Type.BYTE),
        @Db2Field(name = "expansionID", type = Db2Type.BYTE),
        @Db2Field(name = "maxPlayers", type = Db2Type.BYTE),
        @Db2Field(name = "timeOffset", type = Db2Type.BYTE)
})
public class MapEntry implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Directory")
    private String directory;

    @Column(name = "MapName")
    private LocalizedString mapName;

    @Column(name = "MapDescription0")
    private LocalizedString mapDescription0;

    @Column(name = "MapDescription1")
    private LocalizedString mapDescription1;

    @Column(name = "PvpShortDescription")
    private LocalizedString pvpShortDescription;

    @Column(name = "PvpLongDescription")
    private LocalizedString pvpLongDescription;

    @Column(name = "Flags1")
    private Integer flags1;

    @Column(name = "Flags2")
    private Integer flags2;

    @Column(name = "MinimapIconScale")
    private Float minimapIconScale;

    @Column(name = "CorpseX")
    private Float corpseX;

    @Column(name = "CorpseY")
    private Float corpseY;

    @Column(name = "AreaTableID")
    private Short areaTableID;

    @Column(name = "LoadingScreenID")
    private Short loadingScreenID;

    @Column(name = "CorpseMapID")
    private Short corpseMapID;

    @Column(name = "TimeOfDayOverride")
    private Short timeOfDayOverride;

    @Column(name = "ParentMapID")
    private Short parentMapID;

    @Column(name = "CosmeticParentMapID")
    private Short cosmeticParentMapID;

    @Column(name = "WindSettingsID")
    private Short windSettingsID;

    @Column(name = "instanceType")
    private Byte instanceType;

    @Column(name = "MapType")
    private Byte mapType;

    @Column(name = "ExpansionID")
    private Byte expansionID;

    @Column(name = "MaxPlayers")
    private Byte maxPlayers;

    @Column(name = "TimeOffset")
    private Byte timeOffset;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Transient
    private EnumFlag<MapFlag> mapFlags1;

    @Transient
    private EnumFlag<MapFlag2> mapFlags2;


    public boolean isDungeon() {
        return (instanceType == MapTypes.MAP_INSTANCE.ordinal()
                || instanceType == MapTypes.MAP_RAID.ordinal()
                || instanceType == MapTypes.MAP_SCENARIO.ordinal()) && !IsGarrison();
    }

    public boolean isNonRaidDungeon() {
        return instanceType == MapTypes.MAP_INSTANCE.ordinal();
    }

    public boolean isInstanceable() {
        return instanceType == MapTypes.MAP_INSTANCE.ordinal()
                || instanceType == MapTypes.MAP_RAID.ordinal()
                || instanceType == MapTypes.MAP_BATTLEGROUND.ordinal()
                || instanceType == MapTypes.MAP_ARENA.ordinal()
                || instanceType == MapTypes.MAP_SCENARIO.ordinal();
    }

    public boolean isRaid() {
        return instanceType == MapTypes.MAP_RAID.ordinal();
    }

    public boolean isBattleground() {
        return instanceType == MapTypes.MAP_BATTLEGROUND.ordinal();
    }

    public boolean isBattleArena() {
        return instanceType == MapTypes.MAP_ARENA.ordinal();
    }

    public boolean isBattlegroundOrArena() {
        return instanceType == MapTypes.MAP_BATTLEGROUND.ordinal() || instanceType == MapTypes.MAP_ARENA.ordinal();
    }

    public boolean isScenario() {
        return instanceType == MapTypes.MAP_SCENARIO.ordinal();
    }

    public boolean isWorldMap() {
        return instanceType == MapTypes.MAP_COMMON.ordinal();
    }

    public boolean getEntrancePos(int mapid, float x, float y) {
        if (corpseMapID < 0)
            return false;

        if (corpseMapID < 0)
            return false;

        mapid = corpseMapID;
        x = corpseX;
        y = corpseY;
        return new WorldLocal;
    }

    public boolean IsContinent() {
        return switch (id) {
            case 0, 1, 530, 571, 870, 1116, 1220, 1642, 1643, 2222, 2444 -> true;
            default -> false;
        };
    }

    public boolean IsDynamicDifficultyMap() {
        return GetFlags().hasFlag(MapFlag.DynamicDifficulty);
    }

    public boolean IsFlexLocking() {
        return GetFlags().hasFlag(MapFlag.FlexibleRaidLocking);
    }

    public boolean IsGarrison() {
        return GetFlags().hasFlag(MapFlag.Garrison);
    }

    public boolean IsSplitByFaction() {
        return id == 609 || // Acherus (DeathKnight Start)
                id == 1265 ||   // Assault on the Dark Portal (WoD Intro)
                id == 1481 ||   // Mardum (DH Start)
                id == 2175 ||   // Exiles Reach - NPE
                id == 2570;     // Forbidden Reach (Dracthyr/Evoker Start)
    }

    public EnumFlag<MapFlag> GetFlags() {
        if (this.mapFlags1 == null) {

            this.mapFlags1 = EnumFlag.of(MapFlag.class, flags1);
        }
        return this.mapFlags1;
    }

    public EnumFlag<MapFlag2> GetFlags2() {
        if (this.mapFlags2 == null) {

            this.mapFlags2 = EnumFlag.of(MapFlag2.class, flags2);
        }
        return this.mapFlags2;
    }

}
