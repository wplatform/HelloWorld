package com.github.mmo.dbc.domain;

import com.github.mmo.common.LocalizedString;
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


@Table(name = "currency_types")
@Db2DataBind(name = "CurrencyTypes.db2", layoutHash = 0x6CC25CBF, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "maxQty", type = Db2Type.INT),
        @Db2Field(name = "maxEarnablePerWeek", type = Db2Type.INT),
        @Db2Field(name = "flags", type = Db2Type.INT),
        @Db2Field(name = "categoryID", type = Db2Type.BYTE),
        @Db2Field(name = "spellCategory", type = Db2Type.BYTE),
        @Db2Field(name = "quality", type = Db2Type.BYTE),
        @Db2Field(name = "inventoryIconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellWeight", type = Db2Type.INT)
})
public class CurrencyType implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("Description")
    private LocalizedString description;

    @Column("MaxQty")
    private Integer maxQty;

    @Column("MaxEarnablePerWeek")
    private Integer maxEarnablePerWeek;

    @Column("Flags")
    private Integer flags;

    @Column("CategoryID")
    private Short categoryID;

    @Column("SpellCategory")
    private Byte spellCategory;

    @Column("Quality")
    private Byte quality;

    @Column("InventoryIconFileID")
    private Integer inventoryIconFileID;

    @Column("SpellWeight")
    private Integer spellWeight;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
