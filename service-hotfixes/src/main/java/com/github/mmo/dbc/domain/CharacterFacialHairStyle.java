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
@Table(name = "character_facial_hairstyles")
@Db2DataBind(name = "CharacterFacialHairStyles.db2", layoutHash = 0x47D79688, fields = {
        @Db2Field(name = {"geoset1", "geoset2", "geoset3", "geoset4", "geoset5"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "raceID", type = Db2Type.BYTE),
        @Db2Field(name = "sexID", type = Db2Type.BYTE),
        @Db2Field(name = "variationID", type = Db2Type.BYTE)
})
public class CharacterFacialHairStyle implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Geoset1")
    private Integer geoset1;

    @Column(name = "Geoset2")
    private Integer geoset2;

    @Column(name = "Geoset3")
    private Integer geoset3;

    @Column(name = "Geoset4")
    private Integer geoset4;

    @Column(name = "Geoset5")
    private Integer geoset5;

    @Column(name = "RaceID")
    private Byte raceID;

    @Column(name = "SexID")
    private Byte sexID;

    @Column(name = "VariationID")
    private Byte variationID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
