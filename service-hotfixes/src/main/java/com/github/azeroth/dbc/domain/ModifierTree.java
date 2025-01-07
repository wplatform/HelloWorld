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


@Table(name = "modifier_tree")
@Db2DataBind(name = "ModifierTree.db2", layoutHash = 0x7718AFC2, fields = {
        @Db2Field(name = "asset", type = Db2Type.INT, signed = true),
        @Db2Field(name = "secondaryAsset", type = Db2Type.INT, signed = true),
        @Db2Field(name = "parent", type = Db2Type.INT),
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "tertiaryAsset", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "operator", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "amount", type = Db2Type.BYTE, signed = true)
})
public class ModifierTree implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Asset")
    private Integer asset;

    @Column("SecondaryAsset")
    private Integer secondaryAsset;

    @Column("Parent")
    private Integer parent;

    @Column("Type")
    private Short type;

    @Column("TertiaryAsset")
    private Byte tertiaryAsset;

    @Column("Operator")
    private Byte operator;

    @Column("Amount")
    private Byte amount;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
