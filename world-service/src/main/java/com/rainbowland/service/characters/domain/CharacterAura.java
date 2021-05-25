package com.rainbowland.service.characters.domain;

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
@Table("character_aura")
public class CharacterAura {

    @Column("guid")
    private Long guid;
    @Column("casterGuid")
    private byte[] casterGuid;
    @Column("itemGuid")
    private byte[] itemGuid;
    @Column("spell")
    private Integer spell;
    @Column("effectMask")
    private Integer effectMask;
    @Column("recalculateMask")
    private Integer recalculateMask;
    @Column("difficulty")
    private Integer difficulty;
    @Column("stackCount")
    private Integer stackCount;
    @Column("maxDuration")
    private Integer maxDuration;
    @Column("remainTime")
    private Integer remainTime;
    @Column("remainCharges")
    private Integer remainCharges;
    @Column("castItemId")
    private Integer castItemId;
    @Column("castItemLevel")
    private Integer castItemLevel;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterAura> {

        public CharacterAura convert(Row row) {
            CharacterAura domain = new CharacterAura();
            domain.setGuid(row.get("guid", Long.class));
            domain.setCasterGuid(row.get("casterGuid", byte[].class));
            domain.setItemGuid(row.get("itemGuid", byte[].class));
            domain.setSpell(row.get("spell", Integer.class));
            domain.setEffectMask(row.get("effectMask", Integer.class));
            domain.setRecalculateMask(row.get("recalculateMask", Integer.class));
            domain.setDifficulty(row.get("difficulty", Integer.class));
            domain.setStackCount(row.get("stackCount", Integer.class));
            domain.setMaxDuration(row.get("maxDuration", Integer.class));
            domain.setRemainTime(row.get("remainTime", Integer.class));
            domain.setRemainCharges(row.get("remainCharges", Integer.class));
            domain.setCastItemId(row.get("castItemId", Integer.class));
            domain.setCastItemLevel(row.get("castItemLevel", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterAura, OutboundRow> {

        public OutboundRow convert(CharacterAura source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getCasterGuid()).ifPresent(e -> row.put("casterGuid", Parameter.from(e)));
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getEffectMask()).ifPresent(e -> row.put("effectMask", Parameter.from(e)));
            Optional.ofNullable(source.getRecalculateMask()).ifPresent(e -> row.put("recalculateMask", Parameter.from(e)));
            Optional.ofNullable(source.getDifficulty()).ifPresent(e -> row.put("difficulty", Parameter.from(e)));
            Optional.ofNullable(source.getStackCount()).ifPresent(e -> row.put("stackCount", Parameter.from(e)));
            Optional.ofNullable(source.getMaxDuration()).ifPresent(e -> row.put("maxDuration", Parameter.from(e)));
            Optional.ofNullable(source.getRemainTime()).ifPresent(e -> row.put("remainTime", Parameter.from(e)));
            Optional.ofNullable(source.getRemainCharges()).ifPresent(e -> row.put("remainCharges", Parameter.from(e)));
            Optional.ofNullable(source.getCastItemId()).ifPresent(e -> row.put("castItemId", Parameter.from(e)));
            Optional.ofNullable(source.getCastItemLevel()).ifPresent(e -> row.put("castItemLevel", Parameter.from(e)));
            return row;
        }
    }

}
