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
@Table("item_level_selector_quality_set")
public class ItemLevelSelectorQualitySet {

    @Column("ID")
    private Integer id;
    @Column("IlvlRare")
    private Integer ilvlRare;
    @Column("IlvlEpic")
    private Integer ilvlEpic;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemLevelSelectorQualitySet> {

        public ItemLevelSelectorQualitySet convert(Row row) {
            ItemLevelSelectorQualitySet domain = new ItemLevelSelectorQualitySet();
            domain.setId(row.get("ID", Integer.class));
            domain.setIlvlRare(row.get("IlvlRare", Integer.class));
            domain.setIlvlEpic(row.get("IlvlEpic", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemLevelSelectorQualitySet, OutboundRow> {

        public OutboundRow convert(ItemLevelSelectorQualitySet source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getIlvlRare()).ifPresent(e -> row.put("IlvlRare", Parameter.from(e)));
            Optional.ofNullable(source.getIlvlEpic()).ifPresent(e -> row.put("IlvlEpic", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
