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
@Table("spell_group_stack_rules")
public class SpellGroupStackRules {

    @Column("group_id")
    private Integer groupId;
    @Column("stack_rule")
    private Integer stackRule;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellGroupStackRules> {

        public SpellGroupStackRules convert(Row row) {
            SpellGroupStackRules domain = new SpellGroupStackRules();
            domain.setGroupId(row.get("group_id", Integer.class));
            domain.setStackRule(row.get("stack_rule", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellGroupStackRules, OutboundRow> {

        public OutboundRow convert(SpellGroupStackRules source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("group_id", Parameter.from(e)));
            Optional.ofNullable(source.getStackRule()).ifPresent(e -> row.put("stack_rule", Parameter.from(e)));
            return row;
        }
    }

}
