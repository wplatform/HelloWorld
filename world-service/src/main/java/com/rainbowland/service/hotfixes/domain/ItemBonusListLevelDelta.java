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
@Table("item_bonus_list_level_delta")
public class ItemBonusListLevelDelta {

    @Column("ItemLevelDelta")
    private Integer itemLevelDelta;
    @Column("ID")
    private Integer id;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemBonusListLevelDelta> {

        public ItemBonusListLevelDelta convert(Row row) {
            ItemBonusListLevelDelta domain = new ItemBonusListLevelDelta();
            domain.setItemLevelDelta(row.get("ItemLevelDelta", Integer.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemBonusListLevelDelta, OutboundRow> {

        public OutboundRow convert(ItemBonusListLevelDelta source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemLevelDelta()).ifPresent(e -> row.put("ItemLevelDelta", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
