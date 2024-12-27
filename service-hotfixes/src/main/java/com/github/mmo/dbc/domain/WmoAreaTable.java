package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
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
@Table(name = "wmo_area_table")
@Db2DataBind(name = "WMOAreaTable.db2", layoutHash = 0x4616C893, indexField = 12, parentIndexField = 14, fields = {
        @Db2Field(name = "areaName", type = Db2Type.STRING),
        @Db2Field(name = "wmoGroupID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "ambienceID", type = Db2Type.SHORT),
        @Db2Field(name = "zoneMusic", type = Db2Type.SHORT),
        @Db2Field(name = "introSound", type = Db2Type.SHORT),
        @Db2Field(name = "areaTableID", type = Db2Type.SHORT),
        @Db2Field(name = "uwIntroSound", type = Db2Type.SHORT),
        @Db2Field(name = "uwAmbience", type = Db2Type.SHORT),
        @Db2Field(name = "nameSetID", type = Db2Type.BYTE),
        @Db2Field(name = "soundProviderPref", type = Db2Type.BYTE),
        @Db2Field(name = "soundProviderPrefUnderwater", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "uwZoneMusic", type = Db2Type.INT),
        @Db2Field(name = "wmoID", type = Db2Type.SHORT)
})
public class WmoAreaTable implements DbcEntity {
    @Column(name = "AreaName")
    private LocalizedString areaName;

    @Column(name = "WmoGroupID")
    private Integer wmoGroupID;

    @Column(name = "AmbienceID")
    private Short ambienceID;

    @Column(name = "ZoneMusic")
    private Short zoneMusic;

    @Column(name = "IntroSound")
    private Short introSound;

    @Column(name = "AreaTableID")
    private Short areaTableID;

    @Column(name = "UwIntroSound")
    private Short uwIntroSound;

    @Column(name = "UwAmbience")
    private Short uwAmbience;

    @Column(name = "NameSetID")
    private Byte nameSetID;

    @Column(name = "SoundProviderPref")
    private Byte soundProviderPref;

    @Column(name = "SoundProviderPrefUnderwater")
    private Byte soundProviderPrefUnderwater;

    @Column(name = "Flags")
    private Short flags;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "UwZoneMusic")
    private Integer uwZoneMusic;

    @Column(name = "WmoID")
    private Short wmoID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
