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
@Table("toy")
public class Toy {

    @Column("SourceText")
    private String sourceText;
    @Column("ID")
    private Integer id;
    @Column("ItemID")
    private Integer itemId;
    @Column("Flags")
    private Integer flags;
    @Column("SourceTypeEnum")
    private Integer sourceTypeEnum;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Toy> {

        public Toy convert(Row row) {
            Toy domain = new Toy();
            domain.setSourceText(row.get("SourceText", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setSourceTypeEnum(row.get("SourceTypeEnum", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Toy, OutboundRow> {

        public OutboundRow convert(Toy source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSourceText()).ifPresent(e -> row.put("SourceText", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getSourceTypeEnum()).ifPresent(e -> row.put("SourceTypeEnum", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
