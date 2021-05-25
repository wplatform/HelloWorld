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
@Table("guild_rewards")
public class GuildRewards {

    @Column("ItemID")
    private Integer itemId;
    @Column("MinGuildRep")
    private Integer minGuildRep;
    @Column("RaceMask")
    private Long raceMask;
    @Column("Cost")
    private Long cost;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GuildRewards> {

        public GuildRewards convert(Row row) {
            GuildRewards domain = new GuildRewards();
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setMinGuildRep(row.get("MinGuildRep", Integer.class));
            domain.setRaceMask(row.get("RaceMask", Long.class));
            domain.setCost(row.get("Cost", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GuildRewards, OutboundRow> {

        public OutboundRow convert(GuildRewards source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getMinGuildRep()).ifPresent(e -> row.put("MinGuildRep", Parameter.from(e)));
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("RaceMask", Parameter.from(e)));
            Optional.ofNullable(source.getCost()).ifPresent(e -> row.put("Cost", Parameter.from(e)));
            return row;
        }
    }

}
