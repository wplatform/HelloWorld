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


@Getter
@Setter
@ToString


@Table(name = "character_facial_hairstyles")
@Db2DataBind(name = "CharacterFacialHairStyles.db2", layoutHash = 0x47D79688, fields = {
        @Db2Field(name = {"geoset1", "geoset2", "geoset3", "geoset4", "geoset5"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "raceID", type = Db2Type.BYTE),
        @Db2Field(name = "sexID", type = Db2Type.BYTE),
        @Db2Field(name = "variationID", type = Db2Type.BYTE)
})
public class CharacterFacialHairStyle implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Geoset1")
    private Integer geoset1;

    @Column("Geoset2")
    private Integer geoset2;

    @Column("Geoset3")
    private Integer geoset3;

    @Column("Geoset4")
    private Integer geoset4;

    @Column("Geoset5")
    private Integer geoset5;

    @Column("RaceID")
    private Byte raceID;

    @Column("SexID")
    private Byte sexID;

    @Column("VariationID")
    private Byte variationID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
