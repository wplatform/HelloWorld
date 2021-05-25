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
@Table("item_price_base")
public class ItemPriceBase {

    @Column("ID")
    private Integer id;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("Armor")
    private Double armor;
    @Column("Weapon")
    private Double weapon;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemPriceBase> {

        public ItemPriceBase convert(Row row) {
            ItemPriceBase domain = new ItemPriceBase();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setArmor(row.get("Armor", Double.class));
            domain.setWeapon(row.get("Weapon", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemPriceBase, OutboundRow> {

        public OutboundRow convert(ItemPriceBase source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getArmor()).ifPresent(e -> row.put("Armor", Parameter.from(e)));
            Optional.ofNullable(source.getWeapon()).ifPresent(e -> row.put("Weapon", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
