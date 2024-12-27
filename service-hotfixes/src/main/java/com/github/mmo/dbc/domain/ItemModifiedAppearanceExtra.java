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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "item_modified_appearance_extra")
@Db2DataBind(name = "ItemModifiedAppearanceExtra.db2", layoutHash = 0x77212236, fields = {
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "unequippedIconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "sheatheType", type = Db2Type.BYTE),
        @Db2Field(name = "displayWeaponSubclassID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "displayInventoryType", type = Db2Type.BYTE, signed = true),
})
public class ItemModifiedAppearanceExtra implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @ColumnDefault("0")
    @Column(name = "IconFileDataID", nullable = false)
    private Integer iconFileDataID;

    @ColumnDefault("0")
    @Column(name = "UnequippedIconFileDataID", nullable = false)
    private Integer unequippedIconFileDataID;

    @ColumnDefault("'0'")
    @Column(name = "SheatheType", columnDefinition = "tinyint UNSIGNED not null")
    private Short sheatheType;

    @ColumnDefault("0")
    @Column(name = "DisplayWeaponSubclassID", nullable = false)
    private Byte displayWeaponSubclassID;

    @ColumnDefault("0")
    @Column(name = "DisplayInventoryType", nullable = false)
    private Byte displayInventoryType;

}