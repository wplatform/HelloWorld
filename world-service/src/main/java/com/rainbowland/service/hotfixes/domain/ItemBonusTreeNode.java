package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("item_bonus_tree_node")
public class ItemBonusTreeNode {

    @Column("ID")
    private Integer id;
    @Column("ItemContext")
    private Integer itemContext;
    @Column("ChildItemBonusTreeID")
    private Integer childItemBonusTreeId;
    @Column("ChildItemBonusListID")
    private Integer childItemBonusListId;
    @Column("ChildItemLevelSelectorID")
    private Integer childItemLevelSelectorId;
    @Column("ItemBonusListGroupID")
    private Integer itemBonusListGroupId;
    @Column("ParentItemBonusTreeNodeID")
    private Integer parentItemBonusTreeNodeId;
    @Column("ParentItemBonusTreeID")
    private Integer parentItemBonusTreeId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemBonusTreeNode> {

        public ItemBonusTreeNode convert(Row row) {
            ItemBonusTreeNode domain = new ItemBonusTreeNode();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemContext(row.get("ItemContext", Integer.class));
            domain.setChildItemBonusTreeId(row.get("ChildItemBonusTreeID", Integer.class));
            domain.setChildItemBonusListId(row.get("ChildItemBonusListID", Integer.class));
            domain.setChildItemLevelSelectorId(row.get("ChildItemLevelSelectorID", Integer.class));
            domain.setItemBonusListGroupId(row.get("ItemBonusListGroupID", Integer.class));
            domain.setParentItemBonusTreeNodeId(row.get("ParentItemBonusTreeNodeID", Integer.class));
            domain.setParentItemBonusTreeId(row.get("ParentItemBonusTreeID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemBonusTreeNode, OutboundRow> {

        public OutboundRow convert(ItemBonusTreeNode source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemContext()).ifPresent(e -> row.put("ItemContext", Parameter.from(e)));
            Optional.ofNullable(source.getChildItemBonusTreeId()).ifPresent(e -> row.put("ChildItemBonusTreeID", Parameter.from(e)));
            Optional.ofNullable(source.getChildItemBonusListId()).ifPresent(e -> row.put("ChildItemBonusListID", Parameter.from(e)));
            Optional.ofNullable(source.getChildItemLevelSelectorId()).ifPresent(e -> row.put("ChildItemLevelSelectorID", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusListGroupId()).ifPresent(e -> row.put("ItemBonusListGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getParentItemBonusTreeNodeId()).ifPresent(e -> row.put("ParentItemBonusTreeNodeID", Parameter.from(e)));
            Optional.ofNullable(source.getParentItemBonusTreeId()).ifPresent(e -> row.put("ParentItemBonusTreeID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
