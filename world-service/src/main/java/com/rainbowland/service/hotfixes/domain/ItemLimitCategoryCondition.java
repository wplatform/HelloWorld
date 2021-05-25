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
@Table("item_limit_category_condition")
public class ItemLimitCategoryCondition {

    @Column("ID")
    private Integer id;
    @Column("AddQuantity")
    private Integer addQuantity;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("ParentItemLimitCategoryID")
    private Integer parentItemLimitCategoryId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemLimitCategoryCondition> {

        public ItemLimitCategoryCondition convert(Row row) {
            ItemLimitCategoryCondition domain = new ItemLimitCategoryCondition();
            domain.setId(row.get("ID", Integer.class));
            domain.setAddQuantity(row.get("AddQuantity", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setParentItemLimitCategoryId(row.get("ParentItemLimitCategoryID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemLimitCategoryCondition, OutboundRow> {

        public OutboundRow convert(ItemLimitCategoryCondition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getAddQuantity()).ifPresent(e -> row.put("AddQuantity", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getParentItemLimitCategoryId()).ifPresent(e -> row.put("ParentItemLimitCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
