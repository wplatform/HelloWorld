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
@Table("skill_fishing_base_level")
public class SkillFishingBaseLevel {

    @Column("entry")
    private Integer entry;
    @Column("skill")
    private Integer skill;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillFishingBaseLevel> {

        public SkillFishingBaseLevel convert(Row row) {
            SkillFishingBaseLevel domain = new SkillFishingBaseLevel();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setSkill(row.get("skill", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillFishingBaseLevel, OutboundRow> {

        public OutboundRow convert(SkillFishingBaseLevel source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getSkill()).ifPresent(e -> row.put("skill", Parameter.from(e)));
            return row;
        }
    }

}
