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
@Table("guild_rank")
public class GuildRank {

    @Column("guildid")
    private Long guildid;
    @Column("rid")
    private Integer rid;
    @Column("rname")
    private String rname;
    @Column("rights")
    private Integer rights;
    @Column("BankMoneyPerDay")
    private Integer bankMoneyPerDay;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildRank> {

        public GuildRank convert(Row row) {
            GuildRank domain = new GuildRank();
            domain.setGuildid(row.get("guildid", Long.class));
            domain.setRid(row.get("rid", Integer.class));
            domain.setRname(row.get("rname", String.class));
            domain.setRights(row.get("rights", Integer.class));
            domain.setBankMoneyPerDay(row.get("BankMoneyPerDay", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildRank, OutboundRow> {

        public OutboundRow convert(GuildRank source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuildid()).ifPresent(e -> row.put("guildid", Parameter.from(e)));
            Optional.ofNullable(source.getRid()).ifPresent(e -> row.put("rid", Parameter.from(e)));
            Optional.ofNullable(source.getRname()).ifPresent(e -> row.put("rname", Parameter.from(e)));
            Optional.ofNullable(source.getRights()).ifPresent(e -> row.put("rights", Parameter.from(e)));
            Optional.ofNullable(source.getBankMoneyPerDay()).ifPresent(e -> row.put("BankMoneyPerDay", Parameter.from(e)));
            return row;
        }
    }

}
