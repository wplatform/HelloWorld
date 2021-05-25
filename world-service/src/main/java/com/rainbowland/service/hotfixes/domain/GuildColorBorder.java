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
@Table("guild_color_border")
public class GuildColorBorder {

    @Column("ID")
    private Integer id;
    @Column("Red")
    private Integer red;
    @Column("Blue")
    private Integer blue;
    @Column("Green")
    private Integer green;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildColorBorder> {

        public GuildColorBorder convert(Row row) {
            GuildColorBorder domain = new GuildColorBorder();
            domain.setId(row.get("ID", Integer.class));
            domain.setRed(row.get("Red", Integer.class));
            domain.setBlue(row.get("Blue", Integer.class));
            domain.setGreen(row.get("Green", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildColorBorder, OutboundRow> {

        public OutboundRow convert(GuildColorBorder source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRed()).ifPresent(e -> row.put("Red", Parameter.from(e)));
            Optional.ofNullable(source.getBlue()).ifPresent(e -> row.put("Blue", Parameter.from(e)));
            Optional.ofNullable(source.getGreen()).ifPresent(e -> row.put("Green", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
