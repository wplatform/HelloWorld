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
@Table(name = "char_start_outfit")
@Db2DataBind(name = "CharStartOutfit.db2", layoutHash = 0x0EEBEE24, parentIndexField = 6, fields = {
        @Db2Field(name = {"itemID1", "itemID2", "itemID3", "itemID4", "itemID5", "itemID6", "itemID7", "itemID8", "itemID9", "itemID10", "itemID11", "itemID12", "itemID13", "itemID14", "itemID15", "itemID16", "itemID17", "itemID18", "itemID19", "itemID20", "itemID21", "itemID22", "itemID23", "itemID24"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "petDisplayID", type = Db2Type.INT),
        @Db2Field(name = "classID", type = Db2Type.BYTE),
        @Db2Field(name = "sexID", type = Db2Type.BYTE),
        @Db2Field(name = "outfitID", type = Db2Type.BYTE),
        @Db2Field(name = "petFamilyID", type = Db2Type.BYTE),
        @Db2Field(name = "raceID", type = Db2Type.BYTE)
})
public class CharStartOutfit implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ItemID1")
    private Integer itemID1;

    @Column(name = "ItemID2")
    private Integer itemID2;

    @Column(name = "ItemID3")
    private Integer itemID3;

    @Column(name = "ItemID4")
    private Integer itemID4;

    @Column(name = "ItemID5")
    private Integer itemID5;

    @Column(name = "ItemID6")
    private Integer itemID6;

    @Column(name = "ItemID7")
    private Integer itemID7;

    @Column(name = "ItemID8")
    private Integer itemID8;

    @Column(name = "ItemID9")
    private Integer itemID9;

    @Column(name = "ItemID10")
    private Integer itemID10;

    @Column(name = "ItemID11")
    private Integer itemID11;

    @Column(name = "ItemID12")
    private Integer itemID12;

    @Column(name = "ItemID13")
    private Integer itemID13;

    @Column(name = "ItemID14")
    private Integer itemID14;

    @Column(name = "ItemID15")
    private Integer itemID15;

    @Column(name = "ItemID16")
    private Integer itemID16;

    @Column(name = "ItemID17")
    private Integer itemID17;

    @Column(name = "ItemID18")
    private Integer itemID18;

    @Column(name = "ItemID19")
    private Integer itemID19;

    @Column(name = "ItemID20")
    private Integer itemID20;

    @Column(name = "ItemID21")
    private Integer itemID21;

    @Column(name = "ItemID22")
    private Integer itemID22;

    @Column(name = "ItemID23")
    private Integer itemID23;

    @Column(name = "ItemID24")
    private Integer itemID24;

    @Column(name = "PetDisplayID")
    private Integer petDisplayID;

    @Column(name = "ClassID")
    private Byte classID;

    @Column(name = "SexID")
    private Byte sexID;

    @Column(name = "OutfitID")
    private Byte outfitID;

    @Column(name = "PetFamilyID")
    private Short petFamilyID;

    @Column(name = "RaceID")
    private Byte raceID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
