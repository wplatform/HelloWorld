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
@Table("spell_interrupts")
public class SpellInterrupts {

    @Column("ID")
    private Integer id;
    @Column("DifficultyID")
    private Integer difficultyId;
    @Column("InterruptFlags")
    private Integer interruptFlags;
    @Column("AuraInterruptFlags1")
    private Integer auraInterruptFlags1;
    @Column("AuraInterruptFlags2")
    private Integer auraInterruptFlags2;
    @Column("ChannelInterruptFlags1")
    private Integer channelInterruptFlags1;
    @Column("ChannelInterruptFlags2")
    private Integer channelInterruptFlags2;
    @Column("SpellID")
    private Integer spellId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellInterrupts> {

        public SpellInterrupts convert(Row row) {
            SpellInterrupts domain = new SpellInterrupts();
            domain.setId(row.get("ID", Integer.class));
            domain.setDifficultyId(row.get("DifficultyID", Integer.class));
            domain.setInterruptFlags(row.get("InterruptFlags", Integer.class));
            domain.setAuraInterruptFlags1(row.get("AuraInterruptFlags1", Integer.class));
            domain.setAuraInterruptFlags2(row.get("AuraInterruptFlags2", Integer.class));
            domain.setChannelInterruptFlags1(row.get("ChannelInterruptFlags1", Integer.class));
            domain.setChannelInterruptFlags2(row.get("ChannelInterruptFlags2", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellInterrupts, OutboundRow> {

        public OutboundRow convert(SpellInterrupts source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDifficultyId()).ifPresent(e -> row.put("DifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getInterruptFlags()).ifPresent(e -> row.put("InterruptFlags", Parameter.from(e)));
            Optional.ofNullable(source.getAuraInterruptFlags1()).ifPresent(e -> row.put("AuraInterruptFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getAuraInterruptFlags2()).ifPresent(e -> row.put("AuraInterruptFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getChannelInterruptFlags1()).ifPresent(e -> row.put("ChannelInterruptFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getChannelInterruptFlags2()).ifPresent(e -> row.put("ChannelInterruptFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
