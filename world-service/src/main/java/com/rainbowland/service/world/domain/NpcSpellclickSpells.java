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
@Table("npc_spellclick_spells")
public class NpcSpellclickSpells {

    @Column("npc_entry")
    private Integer npcEntry;
    @Column("spell_id")
    private Integer spellId;
    @Column("cast_flags")
    private Integer castFlags;
    @Column("user_type")
    private Integer userType;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, NpcSpellclickSpells> {

        public NpcSpellclickSpells convert(Row row) {
            NpcSpellclickSpells domain = new NpcSpellclickSpells();
            domain.setNpcEntry(row.get("npc_entry", Integer.class));
            domain.setSpellId(row.get("spell_id", Integer.class));
            domain.setCastFlags(row.get("cast_flags", Integer.class));
            domain.setUserType(row.get("user_type", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<NpcSpellclickSpells, OutboundRow> {

        public OutboundRow convert(NpcSpellclickSpells source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getNpcEntry()).ifPresent(e -> row.put("npc_entry", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("spell_id", Parameter.from(e)));
            Optional.ofNullable(source.getCastFlags()).ifPresent(e -> row.put("cast_flags", Parameter.from(e)));
            Optional.ofNullable(source.getUserType()).ifPresent(e -> row.put("user_type", Parameter.from(e)));
            return row;
        }
    }

}
