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
@Table(name = "item_modified_appearance")
@Db2DataBind(name = "ItemModifiedAppearance.db2", layoutHash = 0xE64FD18B, indexField = 1, parentIndexField = 0, fields = {
        @Db2Field(name = "itemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "itemAppearanceModifierID", type = Db2Type.BYTE),
        @Db2Field(name = "itemAppearanceID", type = Db2Type.SHORT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE),
        @Db2Field(name = "transmogSourceTypeEnum", type = Db2Type.BYTE, signed = true)
})
public class ItemModifiedAppearance implements DbcEntity {
    @Column(name = "ItemID")
    private Integer itemID;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ItemAppearanceModifierID")
    private Byte itemAppearanceModifierID;

    @Column(name = "ItemAppearanceID")
    private Integer itemAppearanceID;

    @Column(name = "OrderIndex")
    private Byte orderIndex;

    @Column(name = "TransmogSourceTypeEnum")
    private Byte transmogSourceTypeEnum;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
