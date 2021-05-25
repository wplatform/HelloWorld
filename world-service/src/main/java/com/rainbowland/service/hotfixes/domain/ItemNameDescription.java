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
@Table("item_name_description")
public class ItemNameDescription {

    @Column("ID")
    private Integer id;
    @Column("Description")
    private String description;
    @Column("Color")
    private Integer color;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemNameDescription> {

        public ItemNameDescription convert(Row row) {
            ItemNameDescription domain = new ItemNameDescription();
            domain.setId(row.get("ID", Integer.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setColor(row.get("Color", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemNameDescription, OutboundRow> {

        public OutboundRow convert(ItemNameDescription source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getColor()).ifPresent(e -> row.put("Color", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
