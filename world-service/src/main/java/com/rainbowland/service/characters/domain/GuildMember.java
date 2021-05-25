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
@Table("guild_member")
public class GuildMember {

    @Column("guildid")
    private Long guildid;
    @Column("guid")
    private Long guid;
    @Column("rank")
    private Integer rank;
    @Column("pnote")
    private String pnote;
    @Column("offnote")
    private String offnote;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildMember> {

        public GuildMember convert(Row row) {
            GuildMember domain = new GuildMember();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setGuid(row.get("guid", Long.class));
            domain.setRank(row.get("rank", Integer.class));
            domain.setPnote(row.get("pnote", String.class));
            domain.setOffnote(row.get("offnote", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildMember, OutboundRow> {

        public OutboundRow convert(GuildMember source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getRank()).ifPresent(e -> row.put("rank", Parameter.from(e)));
            Optional.ofNullable(source.getPnote()).ifPresent(e -> row.put("pnote", Parameter.from(e)));
            Optional.ofNullable(source.getOffnote()).ifPresent(e -> row.put("offnote", Parameter.from(e)));
            return row;
        }
    }

}
