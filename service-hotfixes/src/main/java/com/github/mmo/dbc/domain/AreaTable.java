package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.EnumFlag;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import com.github.mmo.dbc.defines.AreaFlags;
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
@Table(name = "area_table")
@Db2DataBind(name = "AreaTable.db2", layoutHash = 0x0CA01129, fields = {
        @Db2Field(name = "zoneName", type = Db2Type.STRING_NOT_LOCALIZED),
        @Db2Field(name = "areaName", type = Db2Type.STRING),
        @Db2Field(name = {"flags1", "flags2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "ambientMultiplier", type = Db2Type.FLOAT),
        @Db2Field(name = "continentID", type = Db2Type.SHORT),
        @Db2Field(name = "parentAreaID", type = Db2Type.SHORT),
        @Db2Field(name = "areaBit", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "ambienceID", type = Db2Type.SHORT),
        @Db2Field(name = "zoneMusic", type = Db2Type.SHORT),
        @Db2Field(name = "introSound", type = Db2Type.SHORT),
        @Db2Field(name = {"liquidTypeID1", "liquidTypeID2", "liquidTypeID3", "liquidTypeID4"}, type = Db2Type.SHORT),
        @Db2Field(name = "uwZoneMusic", type = Db2Type.SHORT),
        @Db2Field(name = "uwAmbience", type = Db2Type.SHORT),
        @Db2Field(name = "pvpCombatWorldStateID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "soundProviderPref", type = Db2Type.BYTE),
        @Db2Field(name = "soundProviderPrefUnderwater", type = Db2Type.BYTE),
        @Db2Field(name = "explorationLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "factionGroupMask", type = Db2Type.BYTE),
        @Db2Field(name = "mountFlags", type = Db2Type.BYTE),
        @Db2Field(name = "wildBattlePetLevelMin", type = Db2Type.BYTE),
        @Db2Field(name = "wildBattlePetLevelMax", type = Db2Type.BYTE),
        @Db2Field(name = "windSettingsID", type = Db2Type.BYTE),
        @Db2Field(name = "uwIntroSound", type = Db2Type.INT)
})
public class AreaTable implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ZoneName")
    private String zoneName;

    @Column(name = "AreaName")
    private LocalizedString areaName;

    @Column(name = "Flags1")
    private Integer flags1;

    @Column(name = "Flags2")
    private Integer flags2;

    @Column(name = "AmbientMultiplier")
    private Float ambientMultiplier;

    @Column(name = "ContinentID")
    private Short continentID;

    @Column(name = "ParentAreaID")
    private Short parentAreaID;

    @Column(name = "AreaBit")
    private Short areaBit;

    @Column(name = "AmbienceID")
    private Short ambienceID;

    @Column(name = "ZoneMusic")
    private Short zoneMusic;

    @Column(name = "IntroSound")
    private Short introSound;

    @Column(name = "LiquidTypeID1")
    private Short liquidTypeID1;

    @Column(name = "LiquidTypeID2")
    private Short liquidTypeID2;

    @Column(name = "LiquidTypeID3")
    private Short liquidTypeID3;

    @Column(name = "LiquidTypeID4")
    private Short liquidTypeID4;

    @Column(name = "UwZoneMusic")
    private Short uwZoneMusic;

    @Column(name = "UwAmbience")
    private Short uwAmbience;

    @Column(name = "PvpCombatWorldStateID")
    private Short pvpCombatWorldStateID;

    @Column(name = "SoundProviderPref")
    private Byte soundProviderPref;

    @Column(name = "SoundProviderPrefUnderwater")
    private Byte soundProviderPrefUnderwater;

    @Column(name = "ExplorationLevel")
    private Byte explorationLevel;

    @Column(name = "FactionGroupMask")
    private Byte factionGroupMask;

    @Column(name = "MountFlags")
    private Byte mountFlags;

    @Column(name = "WildBattlePetLevelMin")
    private Byte wildBattlePetLevelMin;

    @Column(name = "WildBattlePetLevelMax")
    private Byte wildBattlePetLevelMax;

    @Column(name = "WindSettingsID")
    private Byte windSettingsID;

    @Column(name = "UwIntroSound")
    private Integer uwIntroSound;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;


    public Short getLiquidTypeID(int index) {
        Short[] shorts = {liquidTypeID1, liquidTypeID2, liquidTypeID3, liquidTypeID4};
        return shorts[index];
    }

    public EnumFlag<AreaFlags> getFlags() {
        return EnumFlag.of(AreaFlags.class, flags1);
    }


    private boolean isSanctuary()
    {
        return getFlags().hasFlag(AreaFlags.NoPvP);
    }

}
