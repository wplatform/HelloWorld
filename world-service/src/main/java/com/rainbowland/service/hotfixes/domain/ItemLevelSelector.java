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
@Table("item_level_selector")
public class ItemLevelSelector {

    @Column("ID")
    private Integer id;
    @Column("MinItemLevel")
    private Integer minItemLevel;
    @Column("ItemLevelSelectorQualitySetID")
    private Integer itemLevelSelectorQualitySetId;
    @Column("AzeriteUnlockMappingSet")
    private Integer azeriteUnlockMappingSet;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemLevelSelector> {

        public ItemLevelSelector convert(Row row) {
            ItemLevelSelector domain = new ItemLevelSelector();
            domain.setId(row.get("ID", Integer.class));
            domain.setMinItemLevel(row.get("MinItemLevel", Integer.class));
            domain.setItemLevelSelectorQualitySetId(row.get("ItemLevelSelectorQualitySetID", Integer.class));
            domain.setAzeriteUnlockMappingSet(row.get("AzeriteUnlockMappingSet", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemLevelSelector, OutboundRow> {

        public OutboundRow convert(ItemLevelSelector source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMinItemLevel()).ifPresent(e -> row.put("MinItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevelSelectorQualitySetId()).ifPresent(e -> row.put("ItemLevelSelectorQualitySetID", Parameter.from(e)));
            Optional.ofNullable(source.getAzeriteUnlockMappingSet()).ifPresent(e -> row.put("AzeriteUnlockMappingSet", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
