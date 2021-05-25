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
@Table("item_refund_instance")
public class ItemRefundInstance {

    @Column("item_guid")
    private Long itemGuid;
    @Column("player_guid")
    private Long playerGuid;
    @Column("paidMoney")
    private Long paidMoney;
    @Column("paidExtendedCost")
    private Integer paidExtendedCost;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemRefundInstance> {

        public ItemRefundInstance convert(Row row) {
            ItemRefundInstance domain = new ItemRefundInstance();
            domain.setItemGuid(row.get("item_guid", Long.class));
            domain.setPlayerGuid(row.get("player_guid", Long.class));
            domain.setPaidMoney(row.get("paidMoney", Long.class));
            domain.setPaidExtendedCost(row.get("paidExtendedCost", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemRefundInstance, OutboundRow> {

        public OutboundRow convert(ItemRefundInstance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("item_guid", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid()).ifPresent(e -> row.put("player_guid", Parameter.from(e)));
            Optional.ofNullable(source.getPaidMoney()).ifPresent(e -> row.put("paidMoney", Parameter.from(e)));
            Optional.ofNullable(source.getPaidExtendedCost()).ifPresent(e -> row.put("paidExtendedCost", Parameter.from(e)));
            return row;
        }
    }

}
