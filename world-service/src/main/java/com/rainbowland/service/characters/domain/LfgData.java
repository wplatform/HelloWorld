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
@Table("lfg_data")
public class LfgData {

    @Column("guid")
    private Integer guid;
    @Column("dungeon")
    private Integer dungeon;
    @Column("state")
    private Integer state;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, LfgData> {

        public LfgData convert(Row row) {
            LfgData domain = new LfgData();
            domain.setGuid(row.get("guid", Integer.class));
            domain.setDungeon(row.get("dungeon", Integer.class));
            domain.setState(row.get("state", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<LfgData, OutboundRow> {

        public OutboundRow convert(LfgData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getDungeon()).ifPresent(e -> row.put("dungeon", Parameter.from(e)));
            Optional.ofNullable(source.getState()).ifPresent(e -> row.put("state", Parameter.from(e)));
            return row;
        }
    }

}
