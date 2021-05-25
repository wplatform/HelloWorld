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
@Table("item_modified_appearance")
public class ItemModifiedAppearance {

    @Column("ID")
    private Integer id;
    @Column("ItemID")
    private Integer itemId;
    @Column("ItemAppearanceModifierID")
    private Integer itemAppearanceModifierId;
    @Column("ItemAppearanceID")
    private Integer itemAppearanceId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("TransmogSourceTypeEnum")
    private Integer transmogSourceTypeEnum;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemModifiedAppearance> {

        public ItemModifiedAppearance convert(Row row) {
            ItemModifiedAppearance domain = new ItemModifiedAppearance();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setItemAppearanceModifierId(row.get("ItemAppearanceModifierID", Integer.class));
            domain.setItemAppearanceId(row.get("ItemAppearanceID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setTransmogSourceTypeEnum(row.get("TransmogSourceTypeEnum", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemModifiedAppearance, OutboundRow> {

        public OutboundRow convert(ItemModifiedAppearance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getItemAppearanceModifierId()).ifPresent(e -> row.put("ItemAppearanceModifierID", Parameter.from(e)));
            Optional.ofNullable(source.getItemAppearanceId()).ifPresent(e -> row.put("ItemAppearanceID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogSourceTypeEnum()).ifPresent(e -> row.put("TransmogSourceTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
