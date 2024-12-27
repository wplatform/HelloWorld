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
@Table(name = "item_appearance")
@Db2DataBind(name = "ItemAppearance.db2", layoutHash = 0x06D35A59, fields = {
        @Db2Field(name = "itemDisplayInfoID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "defaultIconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiOrder", type = Db2Type.INT, signed = true),
        @Db2Field(name = "displayType", type = Db2Type.BYTE)
})
public class ItemAppearance implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ItemDisplayInfoID")
    private Integer itemDisplayInfoID;

    @Column(name = "DefaultIconFileDataID")
    private Integer defaultIconFileDataID;

    @Column(name = "UiOrder")
    private Integer uiOrder;

    @Column(name = "DisplayType")
    private Byte displayType;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
