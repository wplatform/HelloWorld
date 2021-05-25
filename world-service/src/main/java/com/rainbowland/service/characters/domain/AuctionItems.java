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
@Table("auction_items")
public class AuctionItems {

    @Column("auctionId")
    private Integer auctionId;
    @Column("itemGuid")
    private Long itemGuid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AuctionItems> {

        public AuctionItems convert(Row row) {
            AuctionItems domain = new AuctionItems();
            domain.setAuctionId(row.get("auctionId", Integer.class));
            domain.setItemGuid(row.get("itemGuid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AuctionItems, OutboundRow> {

        public OutboundRow convert(AuctionItems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAuctionId()).ifPresent(e -> row.put("auctionId", Parameter.from(e)));
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            return row;
        }
    }

}
