package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
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


@Table(name = "spell_equipped_items")
@Db2DataBind(name = "SpellEquippedItems.db2", layoutHash = 0xCE628176, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "equippedItemInvTypes", type = Db2Type.INT, signed = true),
        @Db2Field(name = "equippedItemSubclass", type = Db2Type.INT, signed = true),
        @Db2Field(name = "equippedItemClass", type = Db2Type.BYTE, signed = true)
})
public class SpellEquippedItem implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("EquippedItemInvTypes")
    private Integer equippedItemInvTypes;

    @Column("EquippedItemSubclass")
    private Integer equippedItemSubclass;

    @Column("EquippedItemClass")
    private Byte equippedItemClass;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
