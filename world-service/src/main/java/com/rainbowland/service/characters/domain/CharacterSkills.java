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
@Table("character_skills")
public class CharacterSkills {

    @Column("guid")
    private Long guid;
    @Column("skill")
    private Integer skill;
    @Column("value")
    private Integer value;
    @Column("max")
    private Integer max;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterSkills> {

        public CharacterSkills convert(Row row) {
            CharacterSkills domain = new CharacterSkills();
            domain.setGuid(row.get("guid", Long.class));
            domain.setSkill(row.get("skill", Integer.class));
            domain.setValue(row.get("value", Integer.class));
            domain.setMax(row.get("max", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterSkills, OutboundRow> {

        public OutboundRow convert(CharacterSkills source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSkill()).ifPresent(e -> row.put("skill", Parameter.from(e)));
            Optional.ofNullable(source.getValue()).ifPresent(e -> row.put("value", Parameter.from(e)));
            Optional.ofNullable(source.getMax()).ifPresent(e -> row.put("max", Parameter.from(e)));
            return row;
        }
    }

}
