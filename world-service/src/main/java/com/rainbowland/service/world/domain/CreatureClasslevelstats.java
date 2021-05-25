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
@Table("creature_classlevelstats")
public class CreatureClasslevelstats {

    @Column("level")
    private Integer level;
    @Column("class")
    private Integer klass;
    @Column("basemana")
    private Integer basemana;
    @Column("attackpower")
    private Integer attackpower;
    @Column("rangedattackpower")
    private Integer rangedattackpower;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureClasslevelstats> {

        public CreatureClasslevelstats convert(Row row) {
            CreatureClasslevelstats domain = new CreatureClasslevelstats();
            domain.setLevel(row.get("level", Integer.class));
            domain.setKlass(row.get("class", Integer.class));
            domain.setBasemana(row.get("basemana", Integer.class));
            domain.setAttackpower(row.get("attackpower", Integer.class));
            domain.setRangedattackpower(row.get("rangedattackpower", Integer.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureClasslevelstats, OutboundRow> {

        public OutboundRow convert(CreatureClasslevelstats source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("class", Parameter.from(e)));
            Optional.ofNullable(source.getBasemana()).ifPresent(e -> row.put("basemana", Parameter.from(e)));
            Optional.ofNullable(source.getAttackpower()).ifPresent(e -> row.put("attackpower", Parameter.from(e)));
            Optional.ofNullable(source.getRangedattackpower()).ifPresent(e -> row.put("rangedattackpower", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
