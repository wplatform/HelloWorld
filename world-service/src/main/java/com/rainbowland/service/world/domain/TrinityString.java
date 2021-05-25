package com.rainbowland.service.world.domain;

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
@Table("trinity_string")
public class TrinityString {

    @Column("entry")
    private Integer entry;
    @Column("content_default")
    private String contentDefault;
    @Column("content_loc1")
    private String contentLoc1;
    @Column("content_loc2")
    private String contentLoc2;
    @Column("content_loc3")
    private String contentLoc3;
    @Column("content_loc4")
    private String contentLoc4;
    @Column("content_loc5")
    private String contentLoc5;
    @Column("content_loc6")
    private String contentLoc6;
    @Column("content_loc7")
    private String contentLoc7;
    @Column("content_loc8")
    private String contentLoc8;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TrinityString> {

        public TrinityString convert(Row row) {
            TrinityString domain = new TrinityString();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setContentDefault(row.get("content_default", String.class));
            domain.setContentLoc1(row.get("content_loc1", String.class));
            domain.setContentLoc2(row.get("content_loc2", String.class));
            domain.setContentLoc3(row.get("content_loc3", String.class));
            domain.setContentLoc4(row.get("content_loc4", String.class));
            domain.setContentLoc5(row.get("content_loc5", String.class));
            domain.setContentLoc6(row.get("content_loc6", String.class));
            domain.setContentLoc7(row.get("content_loc7", String.class));
            domain.setContentLoc8(row.get("content_loc8", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TrinityString, OutboundRow> {

        public OutboundRow convert(TrinityString source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getContentDefault()).ifPresent(e -> row.put("content_default", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc1()).ifPresent(e -> row.put("content_loc1", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc2()).ifPresent(e -> row.put("content_loc2", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc3()).ifPresent(e -> row.put("content_loc3", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc4()).ifPresent(e -> row.put("content_loc4", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc5()).ifPresent(e -> row.put("content_loc5", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc6()).ifPresent(e -> row.put("content_loc6", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc7()).ifPresent(e -> row.put("content_loc7", Parameter.from(e)));
            Optional.ofNullable(source.getContentLoc8()).ifPresent(e -> row.put("content_loc8", Parameter.from(e)));
            return row;
        }
    }

}
