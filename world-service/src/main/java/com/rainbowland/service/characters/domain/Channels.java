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
@Table("channels")
public class Channels {

    @Column("name")
    private String name;
    @Column("team")
    private Integer team;
    @Column("announce")
    private Integer announce;
    @Column("ownership")
    private Integer ownership;
    @Column("password")
    private String password;
    @Column("bannedList")
    private String bannedList;
    @Column("lastUsed")
    private Long lastUsed;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Channels> {

        public Channels convert(Row row) {
            Channels domain = new Channels();
            domain.setName(row.get("name", String.class));
            domain.setTeam(row.get("team", Integer.class));
            domain.setAnnounce(row.get("announce", Integer.class));
            domain.setOwnership(row.get("ownership", Integer.class));
            domain.setPassword(row.get("password", String.class));
            domain.setBannedList(row.get("bannedList", String.class));
            domain.setLastUsed(row.get("lastUsed", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Channels, OutboundRow> {

        public OutboundRow convert(Channels source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getTeam()).ifPresent(e -> row.put("team", Parameter.from(e)));
            Optional.ofNullable(source.getAnnounce()).ifPresent(e -> row.put("announce", Parameter.from(e)));
            Optional.ofNullable(source.getOwnership()).ifPresent(e -> row.put("ownership", Parameter.from(e)));
            Optional.ofNullable(source.getPassword()).ifPresent(e -> row.put("password", Parameter.from(e)));
            Optional.ofNullable(source.getBannedList()).ifPresent(e -> row.put("bannedList", Parameter.from(e)));
            Optional.ofNullable(source.getLastUsed()).ifPresent(e -> row.put("lastUsed", Parameter.from(e)));
            return row;
        }
    }

}
