package com.rainbowland.service.characters.domain;

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
@Table("item_instance_transmog")
public class ItemInstanceTransmog {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("itemModifiedAppearanceAllSpecs")
    private Integer itemModifiedAppearanceAllSpecs;
    @Column("itemModifiedAppearanceSpec1")
    private Integer itemModifiedAppearanceSpec1;
    @Column("itemModifiedAppearanceSpec2")
    private Integer itemModifiedAppearanceSpec2;
    @Column("itemModifiedAppearanceSpec3")
    private Integer itemModifiedAppearanceSpec3;
    @Column("itemModifiedAppearanceSpec4")
    private Integer itemModifiedAppearanceSpec4;
    @Column("spellItemEnchantmentAllSpecs")
    private Integer spellItemEnchantmentAllSpecs;
    @Column("spellItemEnchantmentSpec1")
    private Integer spellItemEnchantmentSpec1;
    @Column("spellItemEnchantmentSpec2")
    private Integer spellItemEnchantmentSpec2;
    @Column("spellItemEnchantmentSpec3")
    private Integer spellItemEnchantmentSpec3;
    @Column("spellItemEnchantmentSpec4")
    private Integer spellItemEnchantmentSpec4;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceTransmog> {

        public ItemInstanceTransmog convert(Row row) {
            ItemInstanceTransmog domain = new ItemInstanceTransmog();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setItemModifiedAppearanceAllSpecs(row.get("itemModifiedAppearanceAllSpecs", Integer.class));
            domain.setItemModifiedAppearanceSpec1(row.get("itemModifiedAppearanceSpec1", Integer.class));
            domain.setItemModifiedAppearanceSpec2(row.get("itemModifiedAppearanceSpec2", Integer.class));
            domain.setItemModifiedAppearanceSpec3(row.get("itemModifiedAppearanceSpec3", Integer.class));
            domain.setItemModifiedAppearanceSpec4(row.get("itemModifiedAppearanceSpec4", Integer.class));
            domain.setSpellItemEnchantmentAllSpecs(row.get("spellItemEnchantmentAllSpecs", Integer.class));
            domain.setSpellItemEnchantmentSpec1(row.get("spellItemEnchantmentSpec1", Integer.class));
            domain.setSpellItemEnchantmentSpec2(row.get("spellItemEnchantmentSpec2", Integer.class));
            domain.setSpellItemEnchantmentSpec3(row.get("spellItemEnchantmentSpec3", Integer.class));
            domain.setSpellItemEnchantmentSpec4(row.get("spellItemEnchantmentSpec4", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceTransmog, OutboundRow> {

        public OutboundRow convert(ItemInstanceTransmog source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceAllSpecs()).ifPresent(e -> row.put("itemModifiedAppearanceAllSpecs", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceSpec1()).ifPresent(e -> row.put("itemModifiedAppearanceSpec1", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceSpec2()).ifPresent(e -> row.put("itemModifiedAppearanceSpec2", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceSpec3()).ifPresent(e -> row.put("itemModifiedAppearanceSpec3", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceSpec4()).ifPresent(e -> row.put("itemModifiedAppearanceSpec4", Parameter.from(e)));
            Optional.ofNullable(source.getSpellItemEnchantmentAllSpecs()).ifPresent(e -> row.put("spellItemEnchantmentAllSpecs", Parameter.from(e)));
            Optional.ofNullable(source.getSpellItemEnchantmentSpec1()).ifPresent(e -> row.put("spellItemEnchantmentSpec1", Parameter.from(e)));
            Optional.ofNullable(source.getSpellItemEnchantmentSpec2()).ifPresent(e -> row.put("spellItemEnchantmentSpec2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellItemEnchantmentSpec3()).ifPresent(e -> row.put("spellItemEnchantmentSpec3", Parameter.from(e)));
            Optional.ofNullable(source.getSpellItemEnchantmentSpec4()).ifPresent(e -> row.put("spellItemEnchantmentSpec4", Parameter.from(e)));
            return row;
        }
    }

}
