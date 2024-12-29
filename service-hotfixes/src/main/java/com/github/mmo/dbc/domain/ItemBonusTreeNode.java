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


@Table(name = "item_bonus_tree_node")
@Db2DataBind(name = "ItemBonusTreeNode.db2", layoutHash = 0x84FE93B7, parentIndexField = 4, fields = {
        @Db2Field(name = "childItemBonusTreeID", type = Db2Type.SHORT),
        @Db2Field(name = "childItemBonusListID", type = Db2Type.SHORT),
        @Db2Field(name = "childItemLevelSelectorID", type = Db2Type.SHORT),
        @Db2Field(name = "itemContext", type = Db2Type.BYTE),
        @Db2Field(name = "parentItemBonusTreeID", type = Db2Type.SHORT)
})
public class ItemBonusTreeNode implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("ChildItemBonusTreeID")
    private Short childItemBonusTreeID;

    @Column("ChildItemBonusListID")
    private Short childItemBonusListID;

    @Column("ChildItemLevelSelectorID")
    private Short childItemLevelSelectorID;

    @Column("ItemContext")
    private Byte itemContext;

    @Column("ParentItemBonusTreeID")
    private Short parentItemBonusTreeID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
