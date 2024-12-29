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


@Table(name = "item_upgrade")
@Db2DataBind(name = "ItemUpgrade.db2", layoutHash = 0x8F3A4137, fields = {
        @Db2Field(name = "currencyAmount", type = Db2Type.INT),
        @Db2Field(name = "prerequisiteID", type = Db2Type.SHORT),
        @Db2Field(name = "currencyType", type = Db2Type.SHORT),
        @Db2Field(name = "itemUpgradePathID", type = Db2Type.BYTE),
        @Db2Field(name = "itemLevelIncrement", type = Db2Type.BYTE)
})
public class ItemUpgrade implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("CurrencyAmount")
    private Integer currencyAmount;

    @Column("PrerequisiteID")
    private Short prerequisiteID;

    @Column("CurrencyType")
    private Short currencyType;

    @Column("ItemUpgradePathID")
    private Short itemUpgradePathID;

    @Column("ItemLevelIncrement")
    private Byte itemLevelIncrement;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
