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

    @Column(name = "CurrencyCount1")
    private Integer currencyCount1;

    @Column(name = "CurrencyCount2")
    private Integer currencyCount2;

    @Column(name = "CurrencyCount3")
    private Integer currencyCount3;

    @Column(name = "CurrencyCount4")
    private Integer currencyCount4;

    @Column(name = "CurrencyCount5")
    private Integer currencyCount5;

    @Column(name = "ItemCount1")
    private Short itemCount1;

    @Column(name = "ItemCount2")
    private Short itemCount2;

    @Column(name = "ItemCount3")
    private Short itemCount3;

    @Column(name = "ItemCount4")
    private Short itemCount4;

    @Column(name = "ItemCount5")
    private Short itemCount5;

    @Column(name = "RequiredArenaRating")
    private Short requiredArenaRating;

    @Column(name = "CurrencyID1")
    private Short currencyID1;

    @Column(name = "CurrencyID2")
    private Short currencyID2;

    @Column(name = "CurrencyID3")
    private Short currencyID3;

    @Column(name = "CurrencyID4")
    private Short currencyID4;

    @Column(name = "CurrencyID5")
    private Short currencyID5;

    @Column(name = "ArenaBracket")
    private Byte arenaBracket;

    @Column(name = "MinFactionID")
    private Byte minFactionID;

    @Column(name = "MinReputation")
    private Byte minReputation;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "RequiredAchievement")
    private Byte requiredAchievement;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
