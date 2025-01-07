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


@Table(name = "creature_display_info_extra")
@Db2DataBind(name = "CreatureDisplayInfoExtra.db2", layoutHash = 0x6DF98EF6, fields = {
        @Db2Field(name = "bakeMaterialResourcesID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "hDBakeMaterialResourcesID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "displayRaceID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "displaySexID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "displayClassID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "skinID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "faceID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "hairStyleID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "hairColorID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "facialHairID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = {"customDisplayOption1", "customDisplayOption2", "customDisplayOption3"}, type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE, signed = true)
})
public class CreatureDisplayInfoExtra implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("BakeMaterialResourcesID")
    private Integer bakeMaterialResourcesID;

    @Column("HDBakeMaterialResourcesID")
    private Integer hDBakeMaterialResourcesID;

    @Column("DisplayRaceID")
    private Byte displayRaceID;

    @Column("DisplaySexID")
    private Byte displaySexID;

    @Column("DisplayClassID")
    private Byte displayClassID;

    @Column("SkinID")
    private Byte skinID;

    @Column("FaceID")
    private Byte faceID;

    @Column("HairStyleID")
    private Byte hairStyleID;

    @Column("HairColorID")
    private Byte hairColorID;

    @Column("FacialHairID")
    private Byte facialHairID;

    @Column("CustomDisplayOption1")
    private Byte customDisplayOption1;

    @Column("CustomDisplayOption2")
    private Byte customDisplayOption2;

    @Column("CustomDisplayOption3")
    private Byte customDisplayOption3;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
