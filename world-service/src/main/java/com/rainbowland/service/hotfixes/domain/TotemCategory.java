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
@Table("totem_category")
public class TotemCategory {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("TotemCategoryType")
    private Integer totemCategoryType;
    @Column("TotemCategoryMask")
    private Integer totemCategoryMask;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TotemCategory> {

        public TotemCategory convert(Row row) {
            TotemCategory domain = new TotemCategory();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setTotemCategoryType(row.get("TotemCategoryType", Integer.class));
            domain.setTotemCategoryMask(row.get("TotemCategoryMask", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TotemCategory, OutboundRow> {

        public OutboundRow convert(TotemCategory source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getTotemCategoryType()).ifPresent(e -> row.put("TotemCategoryType", Parameter.from(e)));
            Optional.ofNullable(source.getTotemCategoryMask()).ifPresent(e -> row.put("TotemCategoryMask", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
