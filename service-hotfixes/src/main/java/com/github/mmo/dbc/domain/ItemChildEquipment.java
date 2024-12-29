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


@Table(name = "item_child_equipment")
@Db2DataBind(name = "ItemChildEquipment.db2", layoutHash = 0xB6940674, parentIndexField = 2, fields = {
        @Db2Field(name = "childItemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "childItemEquipSlot", type = Db2Type.BYTE),
        @Db2Field(name = "parentItemID", type = Db2Type.INT, signed = true)
})
public class ItemChildEquipment implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("ChildItemID")
    private Integer childItemID;

    @Column("ChildItemEquipSlot")
    private Byte childItemEquipSlot;

    @Column("ParentItemID")
    private Integer parentItemID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
