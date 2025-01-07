package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
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


@Table(name = "heirloom")
@Db2DataBind(name = "Heirloom.db2", layoutHash = 0x36887C6F, indexField = 9, fields = {
        @Db2Field(name = "sourceText", type = Db2Type.STRING),
        @Db2Field(name = "itemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "legacyItemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "legacyUpgradedItemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "staticUpgradedItemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"upgradeItemID1", "upgradeItemID2", "upgradeItemID3"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"upgradeItemBonusListID1", "upgradeItemBonusListID2", "upgradeItemBonusListID3"}, type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "sourceTypeEnum", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class Heirloom implements DbcEntity {
    @Column("SourceText")
    private LocalizedString sourceText;

    @Column("ItemID")
    private Integer itemID;

    @Column("LegacyItemID")
    private Integer legacyItemID;

    @Column("LegacyUpgradedItemID")
    private Integer legacyUpgradedItemID;

    @Column("StaticUpgradedItemID")
    private Integer staticUpgradedItemID;

    @Column("UpgradeItemID1")
    private Integer upgradeItemID1;

    @Column("UpgradeItemID2")
    private Integer upgradeItemID2;

    @Column("UpgradeItemID3")
    private Integer upgradeItemID3;

    @Column("UpgradeItemBonusListID1")
    private Short upgradeItemBonusListID1;

    @Column("UpgradeItemBonusListID2")
    private Short upgradeItemBonusListID2;

    @Column("UpgradeItemBonusListID3")
    private Short upgradeItemBonusListID3;

    @Column("Flags")
    private Byte flags;

    @Column("SourceTypeEnum")
    private Byte sourceTypeEnum;

    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
