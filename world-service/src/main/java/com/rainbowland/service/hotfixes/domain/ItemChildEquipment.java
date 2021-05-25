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
@Table("item_child_equipment")
public class ItemChildEquipment {

    @Column("ID")
    private Integer id;
    @Column("ParentItemID")
    private Integer parentItemId;
    @Column("ChildItemID")
    private Integer childItemId;
    @Column("ChildItemEquipSlot")
    private Integer childItemEquipSlot;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemChildEquipment> {

        public ItemChildEquipment convert(Row row) {
            ItemChildEquipment domain = new ItemChildEquipment();
            domain.setId(row.get("ID", Integer.class));
            domain.setParentItemId(row.get("ParentItemID", Integer.class));
            domain.setChildItemId(row.get("ChildItemID", Integer.class));
            domain.setChildItemEquipSlot(row.get("ChildItemEquipSlot", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemChildEquipment, OutboundRow> {

        public OutboundRow convert(ItemChildEquipment source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getParentItemId()).ifPresent(e -> row.put("ParentItemID", Parameter.from(e)));
            Optional.ofNullable(source.getChildItemId()).ifPresent(e -> row.put("ChildItemID", Parameter.from(e)));
            Optional.ofNullable(source.getChildItemEquipSlot()).ifPresent(e -> row.put("ChildItemEquipSlot", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
