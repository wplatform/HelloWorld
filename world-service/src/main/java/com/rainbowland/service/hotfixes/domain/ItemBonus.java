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
@Table("item_bonus")
public class ItemBonus {

    @Column("ID")
    private Integer id;
    @Column("Value1")
    private Integer value1;
    @Column("Value2")
    private Integer value2;
    @Column("Value3")
    private Integer value3;
    @Column("Value4")
    private Integer value4;
    @Column("ParentItemBonusListID")
    private Integer parentItemBonusListId;
    @Column("Type")
    private Integer type;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemBonus> {

        public ItemBonus convert(Row row) {
            ItemBonus domain = new ItemBonus();
            domain.setId(row.get("ID", Integer.class));
            domain.setValue1(row.get("Value1", Integer.class));
            domain.setValue2(row.get("Value2", Integer.class));
            domain.setValue3(row.get("Value3", Integer.class));
            domain.setValue4(row.get("Value4", Integer.class));
            domain.setParentItemBonusListId(row.get("ParentItemBonusListID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemBonus, OutboundRow> {

        public OutboundRow convert(ItemBonus source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getValue1()).ifPresent(e -> row.put("Value1", Parameter.from(e)));
            Optional.ofNullable(source.getValue2()).ifPresent(e -> row.put("Value2", Parameter.from(e)));
            Optional.ofNullable(source.getValue3()).ifPresent(e -> row.put("Value3", Parameter.from(e)));
            Optional.ofNullable(source.getValue4()).ifPresent(e -> row.put("Value4", Parameter.from(e)));
            Optional.ofNullable(source.getParentItemBonusListId()).ifPresent(e -> row.put("ParentItemBonusListID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
