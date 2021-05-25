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
@Table("player_classlevelstats")
public class PlayerClasslevelstats {

    @Column("class")
    private Integer klass;
    @Column("level")
    private Integer level;
    @Column("str")
    private Integer str;
    @Column("agi")
    private Integer agi;
    @Column("sta")
    private Integer sta;
    @Column("inte")
    private Integer inte;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PlayerClasslevelstats> {

        public PlayerClasslevelstats convert(Row row) {
            PlayerClasslevelstats domain = new PlayerClasslevelstats();
            domain.setKlass(row.get("class", Integer.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setStr(row.get("str", Integer.class));
            domain.setAgi(row.get("agi", Integer.class));
            domain.setSta(row.get("sta", Integer.class));
            domain.setInte(row.get("inte", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PlayerClasslevelstats, OutboundRow> {

        public OutboundRow convert(PlayerClasslevelstats source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("class", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getStr()).ifPresent(e -> row.put("str", Parameter.from(e)));
            Optional.ofNullable(source.getAgi()).ifPresent(e -> row.put("agi", Parameter.from(e)));
            Optional.ofNullable(source.getSta()).ifPresent(e -> row.put("sta", Parameter.from(e)));
            Optional.ofNullable(source.getInte()).ifPresent(e -> row.put("inte", Parameter.from(e)));
            return row;
        }
    }

}
