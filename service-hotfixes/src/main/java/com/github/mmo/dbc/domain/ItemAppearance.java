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


@Table(name = "item_appearance")
@Db2DataBind(name = "ItemAppearance.db2", layoutHash = 0x06D35A59, fields = {
        @Db2Field(name = "itemDisplayInfoID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "defaultIconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "uiOrder", type = Db2Type.INT, signed = true),
        @Db2Field(name = "displayType", type = Db2Type.BYTE)
})
public class ItemAppearance implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("ItemDisplayInfoID")
    private Integer itemDisplayInfoID;

    @Column("DefaultIconFileDataID")
    private Integer defaultIconFileDataID;

    @Column("UiOrder")
    private Integer uiOrder;

    @Column("DisplayType")
    private Byte displayType;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
