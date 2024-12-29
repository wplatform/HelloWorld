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


@Table(name = "item_effect")
@Db2DataBind(name = "ItemEffect.db2", layoutHash = 0xA390FA40, parentIndexField = 8, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "coolDownMSec", type = Db2Type.INT, signed = true),
        @Db2Field(name = "categoryCoolDownMSec", type = Db2Type.INT, signed = true),
        @Db2Field(name = "charges", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "spellCategoryID", type = Db2Type.SHORT),
        @Db2Field(name = "chrSpecializationID", type = Db2Type.SHORT),
        @Db2Field(name = "legacySlotIndex", type = Db2Type.BYTE),
        @Db2Field(name = "triggerType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "parentItemID", type = Db2Type.INT, signed = true)
})
public class ItemEffect implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("CoolDownMSec")
    private Integer coolDownMSec;

    @Column("CategoryCoolDownMSec")
    private Integer categoryCoolDownMSec;

    @Column("Charges")
    private Short charges;

    @Column("SpellCategoryID")
    private Short spellCategoryID;

    @Column("ChrSpecializationID")
    private Short chrSpecializationID;

    @Column("LegacySlotIndex")
    private Byte legacySlotIndex;

    @Column("TriggerType")
    private Byte triggerType;

    @Column("ParentItemID")
    private Integer parentItemID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
