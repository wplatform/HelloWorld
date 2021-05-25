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
@Table("instance_reset")
public class InstanceReset {

    @Column("mapid")
    private Integer mapid;
    @Column("difficulty")
    private Integer difficulty;
    @Column("resettime")
    private Long resettime;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, InstanceReset> {

        public InstanceReset convert(Row row) {
            InstanceReset domain = new InstanceReset();
            domain.setMapid(row.get("mapid", Integer.class));
            domain.setDifficulty(row.get("difficulty", Integer.class));
            domain.setResettime(row.get("resettime", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<InstanceReset, OutboundRow> {

        public OutboundRow convert(InstanceReset source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMapid()).ifPresent(e -> row.put("mapid", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty()).ifPresent(e -> row.put("difficulty", Parameter.from(e)));
            Optional.ofNullable(source.getResettime()).ifPresent(e -> row.put("resettime", Parameter.from(e)));
            return row;
        }
    }

}
