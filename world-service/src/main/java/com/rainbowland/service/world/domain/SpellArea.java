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
@Table("spell_area")
public class SpellArea {

    @Column("spell")
    private Integer spell;
    @Column("area")
    private Integer area;
    @Column("quest_start")
    private Integer questStart;
    @Column("quest_end")
    private Integer questEnd;
    @Column("aura_spell")
    private Integer auraSpell;
    @Column("racemask")
    private Long racemask;
    @Column("gender")
    private Integer gender;
    @Column("flags")
    private Integer flags;
    @Column("quest_start_status")
    private Integer questStartStatus;
    @Column("quest_end_status")
    private Integer questEndStatus;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellArea> {

        public SpellArea convert(Row row) {
            SpellArea domain = new SpellArea();
            domain.setSpell(row.get("spell", Integer.class));
            domain.setArea(row.get("area", Integer.class));
            domain.setQuestStart(row.get("quest_start", Integer.class));
            domain.setQuestEnd(row.get("quest_end", Integer.class));
            domain.setAuraSpell(row.get("aura_spell", Integer.class));
            domain.setRacemask(row.get("racemask", Long.class));
            domain.setGender(row.get("gender", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setQuestStartStatus(row.get("quest_start_status", Integer.class));
            domain.setQuestEndStatus(row.get("quest_end_status", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellArea, OutboundRow> {

        public OutboundRow convert(SpellArea source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getArea()).ifPresent(e -> row.put("area", Parameter.from(e)));
            Optional.ofNullable(source.getQuestStart()).ifPresent(e -> row.put("quest_start", Parameter.from(e)));
            Optional.ofNullable(source.getQuestEnd()).ifPresent(e -> row.put("quest_end", Parameter.from(e)));
            Optional.ofNullable(source.getAuraSpell()).ifPresent(e -> row.put("aura_spell", Parameter.from(e)));
            Optional.ofNullable(source.getRacemask()).ifPresent(e -> row.put("racemask", Parameter.from(e)));
            Optional.ofNullable(source.getGender()).ifPresent(e -> row.put("gender", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getQuestStartStatus()).ifPresent(e -> row.put("quest_start_status", Parameter.from(e)));
            Optional.ofNullable(source.getQuestEndStatus()).ifPresent(e -> row.put("quest_end_status", Parameter.from(e)));
            return row;
        }
    }

}
