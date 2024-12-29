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


@Table(name = "item_x_bonus_tree")
@Db2DataBind(name = "ItemXBonusTree.db2", layoutHash = 0x87C4B605, parentIndexField = 1, fields = {
        @Db2Field(name = "itemBonusTreeID", type = Db2Type.SHORT),
        @Db2Field(name = "itemID", type = Db2Type.INT, signed = true)
})
public class ItemXBonusTree implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("ItemBonusTreeID")
    private Short itemBonusTreeID;

    @Column("ItemID")
    private Integer itemID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
