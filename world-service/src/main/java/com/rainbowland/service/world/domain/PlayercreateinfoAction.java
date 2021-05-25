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
@Table("playercreateinfo_action")
public class PlayercreateinfoAction {

    @Column("race")
    private Integer race;
    @Column("class")
    private Integer klass;
    @Column("button")
    private Integer button;
    @Column("action")
    private Integer action;
    @Column("type")
    private Integer type;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayercreateinfoAction> {

        public PlayercreateinfoAction convert(Row row) {
            PlayercreateinfoAction domain = new PlayercreateinfoAction();
            domain.setRace(row.get("race", Integer.class));
            domain.setKlass(row.get("class", Integer.class));
            domain.setButton(row.get("button", Integer.class));
            domain.setAction(row.get("action", Integer.class));
            domain.setType(row.get("type", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayercreateinfoAction, OutboundRow> {

        public OutboundRow convert(PlayercreateinfoAction source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getRace()).ifPresent(e -> row.put("race", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("class", Parameter.from(e)));
            Optional.ofNullable(source.getButton()).ifPresent(e -> row.put("button", Parameter.from(e)));
            Optional.ofNullable(source.getAction()).ifPresent(e -> row.put("action", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            return row;
        }
    }

}
