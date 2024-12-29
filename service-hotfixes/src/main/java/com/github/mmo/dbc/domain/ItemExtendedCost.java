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


@Table(name = "item_extended_cost")
@Db2DataBind(name = "ItemExtendedCost.db2", layoutHash = 0xC31F4DEF, fields = {
        @Db2Field(name = {"itemID1", "itemID2", "itemID3", "itemID4", "itemID5"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"currencyCount1", "currencyCount2", "currencyCount3", "currencyCount4", "currencyCount5"}, type = Db2Type.INT),
        @Db2Field(name = {"itemCount1", "itemCount2", "itemCount3", "itemCount4", "itemCount5"}, type = Db2Type.SHORT),
        @Db2Field(name = "requiredArenaRating", type = Db2Type.SHORT),
        @Db2Field(name = {"currencyID1", "currencyID2", "currencyID3", "currencyID4", "currencyID5"}, type = Db2Type.SHORT),
        @Db2Field(name = "arenaBracket", type = Db2Type.BYTE),
        @Db2Field(name = "minFactionID", type = Db2Type.BYTE),
        @Db2Field(name = "minReputation", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "requiredAchievement", type = Db2Type.BYTE)
})
public class ItemExtendedCost implements DbcEntity {
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

    @Column("CurrencyCount1")
    private Integer currencyCount1;

    @Column("CurrencyCount2")
    private Integer currencyCount2;

    @Column("CurrencyCount3")
    private Integer currencyCount3;

    @Column("CurrencyCount4")
    private Integer currencyCount4;

    @Column("CurrencyCount5")
    private Integer currencyCount5;

    @Column("ItemCount1")
    private Short itemCount1;

    @Column("ItemCount2")
    private Short itemCount2;

    @Column("ItemCount3")
    private Short itemCount3;

    @Column("ItemCount4")
    private Short itemCount4;

    @Column("ItemCount5")
    private Short itemCount5;

    @Column("RequiredArenaRating")
    private Short requiredArenaRating;

    @Column("CurrencyID1")
    private Short currencyID1;

    @Column("CurrencyID2")
    private Short currencyID2;

    @Column("CurrencyID3")
    private Short currencyID3;

    @Column("CurrencyID4")
    private Short currencyID4;

    @Column("CurrencyID5")
    private Short currencyID5;

    @Column("ArenaBracket")
    private Byte arenaBracket;

    @Column("MinFactionID")
    private Byte minFactionID;

    @Column("MinReputation")
    private Byte minReputation;

    @Column("Flags")
    private Byte flags;

    @Column("RequiredAchievement")
    private Byte requiredAchievement;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
