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
@Table("item_level_selector_quality")
public class ItemLevelSelectorQuality {

    @Column("ID")
    private Integer id;
    @Column("QualityItemBonusListID")
    private Integer qualityItemBonusListId;
    @Column("Quality")
    private Integer quality;
    @Column("ParentILSQualitySetID")
    private Integer parentIlsQualitySetId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemLevelSelectorQuality> {

        public ItemLevelSelectorQuality convert(Row row) {
            ItemLevelSelectorQuality domain = new ItemLevelSelectorQuality();
            domain.setId(row.get("ID", Integer.class));
            domain.setQualityItemBonusListId(row.get("QualityItemBonusListID", Integer.class));
            domain.setQuality(row.get("Quality", Integer.class));
            domain.setParentIlsQualitySetId(row.get("ParentILSQualitySetID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemLevelSelectorQuality, OutboundRow> {

        public OutboundRow convert(ItemLevelSelectorQuality source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getQualityItemBonusListId()).ifPresent(e -> row.put("QualityItemBonusListID", Parameter.from(e)));
            Optional.ofNullable(source.getQuality()).ifPresent(e -> row.put("Quality", Parameter.from(e)));
            Optional.ofNullable(source.getParentIlsQualitySetId()).ifPresent(e -> row.put("ParentILSQualitySetID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
