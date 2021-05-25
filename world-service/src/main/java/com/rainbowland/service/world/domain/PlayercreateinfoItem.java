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
@Table("playercreateinfo_item")
public class PlayercreateinfoItem {

    @Column("race")
    private Integer race;
    @Column("class")
    private Integer klass;
    @Column("itemid")
    private Integer itemid;
    @Column("amount")
    private Integer amount;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayercreateinfoItem> {

        public PlayercreateinfoItem convert(Row row) {
            PlayercreateinfoItem domain = new PlayercreateinfoItem();
            domain.setRace(row.get("race", Integer.class));
            domain.setKlass(row.get("class", Integer.class));
            domain.setItemid(row.get("itemid", Integer.class));
            domain.setAmount(row.get("amount", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayercreateinfoItem, OutboundRow> {

        public OutboundRow convert(PlayercreateinfoItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRace()).ifPresent(e -> row.put("race", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("class", Parameter.from(e)));
            Optional.ofNullable(source.getItemid()).ifPresent(e -> row.put("itemid", Parameter.from(e)));
            Optional.ofNullable(source.getAmount()).ifPresent(e -> row.put("amount", Parameter.from(e)));
            return row;
        }
    }

}
