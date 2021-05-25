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
@Table("item")
public class Item {

    @Column("ID")
    private Integer id;
    @Column("ClassID")
    private Integer classId;
    @Column("SubclassID")
    private Integer subclassId;
    @Column("Material")
    private Integer material;
    @Column("InventoryType")
    private Integer inventoryType;
    @Column("SheatheType")
    private Integer sheatheType;
    @Column("SoundOverrideSubclassID")
    private Integer soundOverrideSubclassId;
    @Column("IconFileDataID")
    private Integer iconFileDataId;
    @Column("ItemGroupSoundsID")
    private Integer itemGroupSoundsId;
    @Column("ModifiedCraftingReagentItemID")
    private Integer modifiedCraftingReagentItemId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Item> {

        public Item convert(Row row) {
            Item domain = new Item();
            domain.setId(row.get("ID", Integer.class));
            domain.setClassId(row.get("ClassID", Integer.class));
            domain.setSubclassId(row.get("SubclassID", Integer.class));
            domain.setMaterial(row.get("Material", Integer.class));
            domain.setInventoryType(row.get("InventoryType", Integer.class));
            domain.setSheatheType(row.get("SheatheType", Integer.class));
            domain.setSoundOverrideSubclassId(row.get("SoundOverrideSubclassID", Integer.class));
            domain.setIconFileDataId(row.get("IconFileDataID", Integer.class));
            domain.setItemGroupSoundsId(row.get("ItemGroupSoundsID", Integer.class));
            domain.setModifiedCraftingReagentItemId(row.get("ModifiedCraftingReagentItemID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Item, OutboundRow> {

        public OutboundRow convert(Item source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getClassId()).ifPresent(e -> row.put("ClassID", Parameter.from(e)));
            Optional.ofNullable(source.getSubclassId()).ifPresent(e -> row.put("SubclassID", Parameter.from(e)));
            Optional.ofNullable(source.getMaterial()).ifPresent(e -> row.put("Material", Parameter.from(e)));
            Optional.ofNullable(source.getInventoryType()).ifPresent(e -> row.put("InventoryType", Parameter.from(e)));
            Optional.ofNullable(source.getSheatheType()).ifPresent(e -> row.put("SheatheType", Parameter.from(e)));
            Optional.ofNullable(source.getSoundOverrideSubclassId()).ifPresent(e -> row.put("SoundOverrideSubclassID", Parameter.from(e)));
            Optional.ofNullable(source.getIconFileDataId()).ifPresent(e -> row.put("IconFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getItemGroupSoundsId()).ifPresent(e -> row.put("ItemGroupSoundsID", Parameter.from(e)));
            Optional.ofNullable(source.getModifiedCraftingReagentItemId()).ifPresent(e -> row.put("ModifiedCraftingReagentItemID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
