package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "MaterialResourcesID1")
    private Integer materialResourcesID1;

    @Column(name = "MaterialResourcesID2")
    private Integer materialResourcesID2;

    @Column(name = "MaterialResourcesID3")
    private Integer materialResourcesID3;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "RaceID")
    private Byte raceID;

    @Column(name = "SexID")
    private Byte sexID;

    @Column(name = "BaseSection")
    private Byte baseSection;

    @Column(name = "VariationIndex")
    private Byte variationIndex;

    @Column(name = "ColorIndex")
    private Byte colorIndex;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
