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
    
    @Column("ID")
    private int id;

    @Column("IconFileDataID")
    private Integer iconFileDataID;

    @Column("ClassID")
    private Byte classID;

    @Column("SubclassID")
    private Byte subclassID;

    @Column("SoundOverrideSubclassID")
    private Byte soundOverrideSubclassID;

    @Column("Material")
    private Byte material;

    @Column("InventoryType")
    private Byte inventoryType;

    @Column("SheatheType")
    private Byte sheatheType;

    @Column("ItemGroupSoundsID")
    private Byte itemGroupSoundsID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
