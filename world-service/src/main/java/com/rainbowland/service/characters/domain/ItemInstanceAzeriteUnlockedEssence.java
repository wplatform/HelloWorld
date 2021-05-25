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
@Table("item_instance_azerite_unlocked_essence")
public class ItemInstanceAzeriteUnlockedEssence {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("azeriteEssenceId")
    private Integer azeriteEssenceId;
    @Column("rank")
    private Integer rank;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceAzeriteUnlockedEssence> {

        public ItemInstanceAzeriteUnlockedEssence convert(Row row) {
            ItemInstanceAzeriteUnlockedEssence domain = new ItemInstanceAzeriteUnlockedEssence();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setAzeriteEssenceId(row.get("azeriteEssenceId", Integer.class));
            domain.setRank(row.get("rank", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceAzeriteUnlockedEssence, OutboundRow> {

        public OutboundRow convert(ItemInstanceAzeriteUnlockedEssence source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getAzeriteEssenceId()).ifPresent(e -> row.put("azeriteEssenceId", Parameter.from(e)));
            Optional.ofNullable(source.getRank()).ifPresent(e -> row.put("rank", Parameter.from(e)));
            return row;
        }
    }

}
