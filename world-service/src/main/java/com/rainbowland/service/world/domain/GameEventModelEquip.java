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
@Table("game_event_model_equip")
public class GameEventModelEquip {

    @Column("eventEntry")
    private Integer eventEntry;
    @Column("guid")
    private Long guid;
    @Column("modelid")
    private Integer modelid;
    @Column("equipment_id")
    private Integer equipmentId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameEventModelEquip> {

        public GameEventModelEquip convert(Row row) {
            GameEventModelEquip domain = new GameEventModelEquip();
            domain.setEventEntry(row.get("eventEntry", Integer.class));
            domain.setGuid(row.get("guid", Long.class));
            domain.setModelid(row.get("modelid", Integer.class));
            domain.setEquipmentId(row.get("equipment_id", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameEventModelEquip, OutboundRow> {

        public OutboundRow convert(GameEventModelEquip source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEventEntry()).ifPresent(e -> row.put("eventEntry", Parameter.from(e)));
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getModelid()).ifPresent(e -> row.put("modelid", Parameter.from(e)));
            Optional.ofNullable(source.getEquipmentId()).ifPresent(e -> row.put("equipment_id", Parameter.from(e)));
            return row;
        }
    }

}
