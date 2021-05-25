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
@Table("spell_pet_auras")
public class SpellPetAuras {

    @Column("spell")
    private Integer spell;
    @Column("effectId")
    private Integer effectId;
    @Column("pet")
    private Integer pet;
    @Column("aura")
    private Integer aura;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellPetAuras> {

        public SpellPetAuras convert(Row row) {
            SpellPetAuras domain = new SpellPetAuras();
            domain.setSpell(row.get("spell", Integer.class));
            domain.setEffectId(row.get("effectId", Integer.class));
            domain.setPet(row.get("pet", Integer.class));
            domain.setAura(row.get("aura", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellPetAuras, OutboundRow> {

        public OutboundRow convert(SpellPetAuras source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getEffectId()).ifPresent(e -> row.put("effectId", Parameter.from(e)));
            Optional.ofNullable(source.getPet()).ifPresent(e -> row.put("pet", Parameter.from(e)));
            Optional.ofNullable(source.getAura()).ifPresent(e -> row.put("aura", Parameter.from(e)));
            return row;
        }
    }

}
