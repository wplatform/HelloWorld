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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ChildItemBonusTreeID")
    private Short childItemBonusTreeID;

    @Column(name = "ChildItemBonusListID")
    private Short childItemBonusListID;

    @Column(name = "ChildItemLevelSelectorID")
    private Short childItemLevelSelectorID;

    @Column(name = "ItemContext")
    private Byte itemContext;

    @Column(name = "ParentItemBonusTreeID")
    private Short parentItemBonusTreeID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
