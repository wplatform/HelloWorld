package com.rainbowland.service.hotfixes.domain;

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
@Table("spell_class_options")
public class SpellClassOptions {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("ModalNextSpell")
    private Integer modalNextSpell;
    @Column("SpellClassSet")
    private Integer spellClassSet;
    @Column("SpellClassMask1")
    private Integer spellClassMask1;
    @Column("SpellClassMask2")
    private Integer spellClassMask2;
    @Column("SpellClassMask3")
    private Integer spellClassMask3;
    @Column("SpellClassMask4")
    private Integer spellClassMask4;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellClassOptions> {

        public SpellClassOptions convert(Row row) {
            SpellClassOptions domain = new SpellClassOptions();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setModalNextSpell(row.get("ModalNextSpell", Integer.class));
            domain.setSpellClassSet(row.get("SpellClassSet", Integer.class));
            domain.setSpellClassMask1(row.get("SpellClassMask1", Integer.class));
            domain.setSpellClassMask2(row.get("SpellClassMask2", Integer.class));
            domain.setSpellClassMask3(row.get("SpellClassMask3", Integer.class));
            domain.setSpellClassMask4(row.get("SpellClassMask4", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellClassOptions, OutboundRow> {

        public OutboundRow convert(SpellClassOptions source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getModalNextSpell()).ifPresent(e -> row.put("ModalNextSpell", Parameter.from(e)));
            Optional.ofNullable(source.getSpellClassSet()).ifPresent(e -> row.put("SpellClassSet", Parameter.from(e)));
            Optional.ofNullable(source.getSpellClassMask1()).ifPresent(e -> row.put("SpellClassMask1", Parameter.from(e)));
            Optional.ofNullable(source.getSpellClassMask2()).ifPresent(e -> row.put("SpellClassMask2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellClassMask3()).ifPresent(e -> row.put("SpellClassMask3", Parameter.from(e)));
            Optional.ofNullable(source.getSpellClassMask4()).ifPresent(e -> row.put("SpellClassMask4", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
