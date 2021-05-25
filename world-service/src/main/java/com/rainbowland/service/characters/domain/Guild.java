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
@Table("guild")
public class Guild {

    @Column("guildid")
    private Long guildid;
    @Column("name")
    private String name;
    @Column("leaderguid")
    private Long leaderguid;
    @Column("EmblemStyle")
    private Integer emblemStyle;
    @Column("EmblemColor")
    private Integer emblemColor;
    @Column("BorderStyle")
    private Integer borderStyle;
    @Column("BorderColor")
    private Integer borderColor;
    @Column("BackgroundColor")
    private Integer backgroundColor;
    @Column("info")
    private String info;
    @Column("motd")
    private String motd;
    @Column("createdate")
    private Integer createdate;
    @Column("BankMoney")
    private Long bankMoney;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Guild> {

        public Guild convert(Row row) {
            Guild domain = new Guild();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setName(row.get("name", String.class));
            domain.setLeaderguid(row.get("leaderguid", Long.class));
            domain.setEmblemStyle(row.get("EmblemStyle", Integer.class));
            domain.setEmblemColor(row.get("EmblemColor", Integer.class));
            domain.setBorderStyle(row.get("BorderStyle", Integer.class));
            domain.setBorderColor(row.get("BorderColor", Integer.class));
            domain.setBackgroundColor(row.get("BackgroundColor", Integer.class));
            domain.setInfo(row.get("info", String.class));
            domain.setMotd(row.get("motd", String.class));
            domain.setCreatedate(row.get("createdate", Integer.class));
            domain.setBankMoney(row.get("BankMoney", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Guild, OutboundRow> {

        public OutboundRow convert(Guild source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getLeaderguid()).ifPresent(e -> row.put("leaderguid", Parameter.from(e)));
            Optional.ofNullable(source.getEmblemStyle()).ifPresent(e -> row.put("EmblemStyle", Parameter.from(e)));
            Optional.ofNullable(source.getEmblemColor()).ifPresent(e -> row.put("EmblemColor", Parameter.from(e)));
            Optional.ofNullable(source.getBorderStyle()).ifPresent(e -> row.put("BorderStyle", Parameter.from(e)));
            Optional.ofNullable(source.getBorderColor()).ifPresent(e -> row.put("BorderColor", Parameter.from(e)));
            Optional.ofNullable(source.getBackgroundColor()).ifPresent(e -> row.put("BackgroundColor", Parameter.from(e)));
            Optional.ofNullable(source.getInfo()).ifPresent(e -> row.put("info", Parameter.from(e)));
            Optional.ofNullable(source.getMotd()).ifPresent(e -> row.put("motd", Parameter.from(e)));
            Optional.ofNullable(source.getCreatedate()).ifPresent(e -> row.put("createdate", Parameter.from(e)));
            Optional.ofNullable(source.getBankMoney()).ifPresent(e -> row.put("BankMoney", Parameter.from(e)));
            return row;
        }
    }

}
