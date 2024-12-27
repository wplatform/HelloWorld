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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Asset")
    private Integer asset;

    @Column(name = "SecondaryAsset")
    private Integer secondaryAsset;

    @Column(name = "Parent")
    private Integer parent;

    @Column(name = "Type")
    private Short type;

    @Column(name = "TertiaryAsset")
    private Byte tertiaryAsset;

    @Column(name = "Operator")
    private Byte operator;

    @Column(name = "Amount")
    private Byte amount;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
