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
@Table("skill_perfect_item_template")
public class SkillPerfectItemTemplate {

    @Column("spellId")
    private Integer spellId;
    @Column("requiredSpecialization")
    private Integer requiredSpecialization;
    @Column("perfectCreateChance")
    private Double perfectCreateChance;
    @Column("perfectItemType")
    private Integer perfectItemType;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillPerfectItemTemplate> {

        public SkillPerfectItemTemplate convert(Row row) {
            SkillPerfectItemTemplate domain = new SkillPerfectItemTemplate();
            domain.setSpellId(row.get("spellId", Integer.class));
            domain.setRequiredSpecialization(row.get("requiredSpecialization", Integer.class));
            domain.setPerfectCreateChance(row.get("perfectCreateChance", Double.class));
            domain.setPerfectItemType(row.get("perfectItemType", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillPerfectItemTemplate, OutboundRow> {

        public OutboundRow convert(SkillPerfectItemTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spellId", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredSpecialization()).ifPresent(e -> row.put("requiredSpecialization", Parameter.from(e)));
            Optional.ofNullable(source.getPerfectCreateChance()).ifPresent(e -> row.put("perfectCreateChance", Parameter.from(e)));
            Optional.ofNullable(source.getPerfectItemType()).ifPresent(e -> row.put("perfectItemType", Parameter.from(e)));
            return row;
        }
    }

}
