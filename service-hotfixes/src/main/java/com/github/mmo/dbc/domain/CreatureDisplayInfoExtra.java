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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "BakeMaterialResourcesID")
    private Integer bakeMaterialResourcesID;

    @Column(name = "HDBakeMaterialResourcesID")
    private Integer hDBakeMaterialResourcesID;

    @Column(name = "DisplayRaceID")
    private Byte displayRaceID;

    @Column(name = "DisplaySexID")
    private Byte displaySexID;

    @Column(name = "DisplayClassID")
    private Byte displayClassID;

    @Column(name = "SkinID")
    private Byte skinID;

    @Column(name = "FaceID")
    private Byte faceID;

    @Column(name = "HairStyleID")
    private Byte hairStyleID;

    @Column(name = "HairColorID")
    private Byte hairColorID;

    @Column(name = "FacialHairID")
    private Byte facialHairID;

    @Column(name = "CustomDisplayOption1")
    private Byte customDisplayOption1;

    @Column(name = "CustomDisplayOption2")
    private Byte customDisplayOption2;

    @Column(name = "CustomDisplayOption3")
    private Byte customDisplayOption3;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
