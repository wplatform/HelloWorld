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
@Table("skill_discovery_template")
public class SkillDiscoveryTemplate {

    @Column("spellId")
    private Integer spellId;
    @Column("reqSpell")
    private Integer reqSpell;
    @Column("reqSkillValue")
    private Integer reqSkillValue;
    @Column("chance")
    private Double chance;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillDiscoveryTemplate> {

        public SkillDiscoveryTemplate convert(Row row) {
            SkillDiscoveryTemplate domain = new SkillDiscoveryTemplate();
            domain.setSpellId(row.get("spellId", Integer.class));
            domain.setReqSpell(row.get("reqSpell", Integer.class));
            domain.setReqSkillValue(row.get("reqSkillValue", Integer.class));
            domain.setChance(row.get("chance", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillDiscoveryTemplate, OutboundRow> {

        public OutboundRow convert(SkillDiscoveryTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spellId", Parameter.from(e)));
            Optional.ofNullable(source.getReqSpell()).ifPresent(e -> row.put("reqSpell", Parameter.from(e)));
            Optional.ofNullable(source.getReqSkillValue()).ifPresent(e -> row.put("reqSkillValue", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("chance", Parameter.from(e)));
            return row;
        }
    }

}
