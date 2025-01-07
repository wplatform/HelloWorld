package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
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


@Table(name = "char_sections")
@Db2DataBind(name = "CharSections.db2", layoutHash = 0xE349E55B, fields = {
        @Db2Field(name = {"materialResourcesID1", "materialResourcesID2", "materialResourcesID3"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "raceID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "sexID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "baseSection", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "variationIndex", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "colorIndex", type = Db2Type.BYTE, signed = true)
})
public class CharSection implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("MaterialResourcesID1")
    private Integer materialResourcesID1;

    @Column("MaterialResourcesID2")
    private Integer materialResourcesID2;

    @Column("MaterialResourcesID3")
    private Integer materialResourcesID3;

    @Column("Flags")
    private Short flags;

    @Column("RaceID")
    private Byte raceID;

    @Column("SexID")
    private Byte sexID;

    @Column("BaseSection")
    private Byte baseSection;

    @Column("VariationIndex")
    private Byte variationIndex;

    @Column("ColorIndex")
    private Byte colorIndex;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
