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

    @Column("ID")
    private int id;

    @Column("ItemID1")
    private Integer itemID1;

    @Column("ItemID2")
    private Integer itemID2;

    @Column("ItemID3")
    private Integer itemID3;

    @Column("ItemID4")
    private Integer itemID4;

    @Column("ItemID5")
    private Integer itemID5;

    @Column("ItemID6")
    private Integer itemID6;

    @Column("ItemID7")
    private Integer itemID7;

    @Column("ItemID8")
    private Integer itemID8;

    @Column("ItemID9")
    private Integer itemID9;

    @Column("ItemID10")
    private Integer itemID10;

    @Column("ItemID11")
    private Integer itemID11;

    @Column("ItemID12")
    private Integer itemID12;

    @Column("ItemID13")
    private Integer itemID13;

    @Column("ItemID14")
    private Integer itemID14;

    @Column("ItemID15")
    private Integer itemID15;

    @Column("ItemID16")
    private Integer itemID16;

    @Column("ItemID17")
    private Integer itemID17;

    @Column("ItemID18")
    private Integer itemID18;

    @Column("ItemID19")
    private Integer itemID19;

    @Column("ItemID20")
    private Integer itemID20;

    @Column("ItemID21")
    private Integer itemID21;

    @Column("ItemID22")
    private Integer itemID22;

    @Column("ItemID23")
    private Integer itemID23;

    @Column("ItemID24")
    private Integer itemID24;

    @Column("PetDisplayID")
    private Integer petDisplayID;

    @Column("ClassID")
    private Byte classID;

    @Column("SexID")
    private Byte sexID;

    @Column("OutfitID")
    private Byte outfitID;

    @Column("PetFamilyID")
    private Short petFamilyID;

    @Column("RaceID")
    private Byte raceID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
