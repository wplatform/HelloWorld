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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "CoolDownMSec")
    private Integer coolDownMSec;

    @Column(name = "CategoryCoolDownMSec")
    private Integer categoryCoolDownMSec;

    @Column(name = "Charges")
    private Short charges;

    @Column(name = "SpellCategoryID")
    private Short spellCategoryID;

    @Column(name = "ChrSpecializationID")
    private Short chrSpecializationID;

    @Column(name = "LegacySlotIndex")
    private Byte legacySlotIndex;

    @Column(name = "TriggerType")
    private Byte triggerType;

    @Column(name = "ParentItemID")
    private Integer parentItemID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
