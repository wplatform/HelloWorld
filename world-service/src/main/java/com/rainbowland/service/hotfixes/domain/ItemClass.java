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
@Table("item_class")
public class ItemClass {

    @Column("ID")
    private Integer id;
    @Column("ClassName")
    private String className;
    @Column("ClassID")
    private Integer classId;
    @Column("PriceModifier")
    private Double priceModifier;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemClass> {

        public ItemClass convert(Row row) {
            ItemClass domain = new ItemClass();
            domain.setId(row.get("ID", Integer.class));
            domain.setClassName(row.get("ClassName", String.class));
            domain.setClassId(row.get("ClassID", Integer.class));
            domain.setPriceModifier(row.get("PriceModifier", Double.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemClass, OutboundRow> {

        public OutboundRow convert(ItemClass source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getClassName()).ifPresent(e -> row.put("ClassName", Parameter.from(e)));
            Optional.ofNullable(source.getClassId()).ifPresent(e -> row.put("ClassID", Parameter.from(e)));
            Optional.ofNullable(source.getPriceModifier()).ifPresent(e -> row.put("PriceModifier", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
