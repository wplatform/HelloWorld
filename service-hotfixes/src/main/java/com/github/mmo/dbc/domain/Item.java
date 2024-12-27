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
@Table(name = "item")
@Db2DataBind(name = "Item.db2", layoutHash = 0x0DFCC83D, fields = {
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "classID", type = Db2Type.BYTE),
        @Db2Field(name = "subclassID", type = Db2Type.BYTE),
        @Db2Field(name = "soundOverrideSubclassID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "material", type = Db2Type.BYTE),
        @Db2Field(name = "inventoryType", type = Db2Type.BYTE),
        @Db2Field(name = "sheatheType", type = Db2Type.BYTE),
        @Db2Field(name = "itemGroupSoundsID", type = Db2Type.BYTE)
})
public class Item implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "IconFileDataID")
    private Integer iconFileDataID;

    @Column(name = "ClassID")
    private Byte classID;

    @Column(name = "SubclassID")
    private Byte subclassID;

    @Column(name = "SoundOverrideSubclassID")
    private Byte soundOverrideSubclassID;

    @Column(name = "Material")
    private Byte material;

    @Column(name = "InventoryType")
    private Byte inventoryType;

    @Column(name = "SheatheType")
    private Byte sheatheType;

    @Column(name = "ItemGroupSoundsID")
    private Byte itemGroupSoundsID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
