package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


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
    @Column("AreaName")
    private LocalizedString areaName;

    @Column("WmoGroupID")
    private Integer wmoGroupID;

    @Column("AmbienceID")
    private Short ambienceID;

    @Column("ZoneMusic")
    private Short zoneMusic;

    @Column("IntroSound")
    private Short introSound;

    @Column("AreaTableID")
    private Short areaTableID;

    @Column("UwIntroSound")
    private Short uwIntroSound;

    @Column("UwAmbience")
    private Short uwAmbience;

    @Column("NameSetID")
    private Byte nameSetID;

    @Column("SoundProviderPref")
    private Byte soundProviderPref;

    @Column("SoundProviderPrefUnderwater")
    private Byte soundProviderPrefUnderwater;

    @Column("Flags")
    private Short flags;

    @Id

    @Column("ID")
    private int id;

    @Column("UwZoneMusic")
    private Integer uwZoneMusic;

    @Column("WmoID")
    private Short wmoID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
