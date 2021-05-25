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
@Table("item_x_bonus_tree")
public class ItemXBonusTree {

    @Column("ID")
    private Integer id;
    @Column("ItemBonusTreeID")
    private Integer itemBonusTreeId;
    @Column("ItemID")
    private Integer itemId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemXBonusTree> {

        public ItemXBonusTree convert(Row row) {
            ItemXBonusTree domain = new ItemXBonusTree();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemBonusTreeId(row.get("ItemBonusTreeID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemXBonusTree, OutboundRow> {

        public OutboundRow convert(ItemXBonusTree source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusTreeId()).ifPresent(e -> row.put("ItemBonusTreeID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
