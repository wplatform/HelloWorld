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
@Table("skill_extra_item_template")
public class SkillExtraItemTemplate {

    @Column("spellId")
    private Integer spellId;
    @Column("requiredSpecialization")
    private Integer requiredSpecialization;
    @Column("additionalCreateChance")
    private Double additionalCreateChance;
    @Column("additionalMaxNum")
    private Integer additionalMaxNum;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillExtraItemTemplate> {

        public SkillExtraItemTemplate convert(Row row) {
            SkillExtraItemTemplate domain = new SkillExtraItemTemplate();
            domain.setSpellId(row.get("spellId", Integer.class));
            domain.setRequiredSpecialization(row.get("requiredSpecialization", Integer.class));
            domain.setAdditionalCreateChance(row.get("additionalCreateChance", Double.class));
            domain.setAdditionalMaxNum(row.get("additionalMaxNum", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillExtraItemTemplate, OutboundRow> {

        public OutboundRow convert(SkillExtraItemTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spellId", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSpecialization()).ifPresent(e -> row.put("requiredSpecialization", Parameter.from(e)));
            Optional.ofNullable(source.getAdditionalCreateChance()).ifPresent(e -> row.put("additionalCreateChance", Parameter.from(e)));
            Optional.ofNullable(source.getAdditionalMaxNum()).ifPresent(e -> row.put("additionalMaxNum", Parameter.from(e)));
            return row;
        }
    }

}
