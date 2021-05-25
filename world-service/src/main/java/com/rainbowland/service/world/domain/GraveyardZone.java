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
@Table("graveyard_zone")
public class GraveyardZone {

    @Column("ID")
    private Integer id;
    @Column("GhostZone")
    private Integer ghostZone;
    @Column("Faction")
    private Integer faction;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GraveyardZone> {

        public GraveyardZone convert(Row row) {
            GraveyardZone domain = new GraveyardZone();
            domain.setId(row.get("ID", Integer.class));
            domain.setGhostZone(row.get("GhostZone", Integer.class));
            domain.setFaction(row.get("Faction", Integer.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GraveyardZone, OutboundRow> {

        public OutboundRow convert(GraveyardZone source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getGhostZone()).ifPresent(e -> row.put("GhostZone", Parameter.from(e)));
            Optional.ofNullable(source.getFaction()).ifPresent(e -> row.put("Faction", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
