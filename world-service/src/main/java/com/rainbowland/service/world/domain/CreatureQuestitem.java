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
@Table("creature_questitem")
public class CreatureQuestitem {

    @Column("CreatureEntry")
    private Integer creatureEntry;
    @Column("Idx")
    private Integer idx;
    @Column("ItemId")
    private Integer itemId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureQuestitem> {

        public CreatureQuestitem convert(Row row) {
            CreatureQuestitem domain = new CreatureQuestitem();
            domain.setCreatureEntry(row.get("CreatureEntry", Integer.class));
            domain.setIdx(row.get("Idx", Integer.class));
            domain.setItemId(row.get("ItemId", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureQuestitem, OutboundRow> {

        public OutboundRow convert(CreatureQuestitem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureEntry()).ifPresent(e -> row.put("CreatureEntry", Parameter.from(e)));
            Optional.ofNullable(source.getIdx()).ifPresent(e -> row.put("Idx", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemId", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
