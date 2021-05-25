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
@Table("spell_proc")
public class SpellProc {

    @Column("SpellId")
    private Integer spellId;
    @Column("SchoolMask")
    private Integer schoolMask;
    @Column("SpellFamilyName")
    private Integer spellFamilyName;
    @Column("SpellFamilyMask0")
    private Integer spellFamilyMask0;
    @Column("SpellFamilyMask1")
    private Integer spellFamilyMask1;
    @Column("SpellFamilyMask2")
    private Integer spellFamilyMask2;
    @Column("SpellFamilyMask3")
    private Integer spellFamilyMask3;
    @Column("ProcFlags")
    private Integer procFlags;
    @Column("SpellTypeMask")
    private Integer spellTypeMask;
    @Column("SpellPhaseMask")
    private Integer spellPhaseMask;
    @Column("HitMask")
    private Integer hitMask;
    @Column("AttributesMask")
    private Integer attributesMask;
    @Column("DisableEffectsMask")
    private Integer disableEffectsMask;
    @Column("ProcsPerMinute")
    private Double procsPerMinute;
    @Column("Chance")
    private Double chance;
    @Column("Cooldown")
    private Integer cooldown;
    @Column("Charges")
    private Integer charges;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellProc> {

        public SpellProc convert(Row row) {
            SpellProc domain = new SpellProc();
            domain.setSpellId(row.get("SpellId", Integer.class));
            domain.setSchoolMask(row.get("SchoolMask", Integer.class));
            domain.setSpellFamilyName(row.get("SpellFamilyName", Integer.class));
            domain.setSpellFamilyMask0(row.get("SpellFamilyMask0", Integer.class));
            domain.setSpellFamilyMask1(row.get("SpellFamilyMask1", Integer.class));
            domain.setSpellFamilyMask2(row.get("SpellFamilyMask2", Integer.class));
            domain.setSpellFamilyMask3(row.get("SpellFamilyMask3", Integer.class));
            domain.setProcFlags(row.get("ProcFlags", Integer.class));
            domain.setSpellTypeMask(row.get("SpellTypeMask", Integer.class));
            domain.setSpellPhaseMask(row.get("SpellPhaseMask", Integer.class));
            domain.setHitMask(row.get("HitMask", Integer.class));
            domain.setAttributesMask(row.get("AttributesMask", Integer.class));
            domain.setDisableEffectsMask(row.get("DisableEffectsMask", Integer.class));
            domain.setProcsPerMinute(row.get("ProcsPerMinute", Double.class));
            domain.setChance(row.get("Chance", Double.class));
            domain.setCooldown(row.get("Cooldown", Integer.class));
            domain.setCharges(row.get("Charges", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellProc, OutboundRow> {

        public OutboundRow convert(SpellProc source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellId", Parameter.from(e)));
            Optional.ofNullable(source.getSchoolMask()).ifPresent(e -> row.put("SchoolMask", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyName()).ifPresent(e -> row.put("SpellFamilyName", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyMask0()).ifPresent(e -> row.put("SpellFamilyMask0", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyMask1()).ifPresent(e -> row.put("SpellFamilyMask1", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyMask2()).ifPresent(e -> row.put("SpellFamilyMask2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellFamilyMask3()).ifPresent(e -> row.put("SpellFamilyMask3", Parameter.from(e)));
            Optional.ofNullable(source.getProcFlags()).ifPresent(e -> row.put("ProcFlags", Parameter.from(e)));
            Optional.ofNullable(source.getSpellTypeMask()).ifPresent(e -> row.put("SpellTypeMask", Parameter.from(e)));
            Optional.ofNullable(source.getSpellPhaseMask()).ifPresent(e -> row.put("SpellPhaseMask", Parameter.from(e)));
            Optional.ofNullable(source.getHitMask()).ifPresent(e -> row.put("HitMask", Parameter.from(e)));
            Optional.ofNullable(source.getAttributesMask()).ifPresent(e -> row.put("AttributesMask", Parameter.from(e)));
            Optional.ofNullable(source.getDisableEffectsMask()).ifPresent(e -> row.put("DisableEffectsMask", Parameter.from(e)));
            Optional.ofNullable(source.getProcsPerMinute()).ifPresent(e -> row.put("ProcsPerMinute", Parameter.from(e)));
            Optional.ofNullable(source.getChance()).ifPresent(e -> row.put("Chance", Parameter.from(e)));
            Optional.ofNullable(source.getCooldown()).ifPresent(e -> row.put("Cooldown", Parameter.from(e)));
            Optional.ofNullable(source.getCharges()).ifPresent(e -> row.put("Charges", Parameter.from(e)));
            return row;
        }
    }

}
