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
@Table("auction_bidders")
public class AuctionBidders {

    @Column("auctionId")
    private Integer auctionId;
    @Column("playerGuid")
    private Long playerGuid;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AuctionBidders> {

        public AuctionBidders convert(Row row) {
            AuctionBidders domain = new AuctionBidders();
            domain.setAuctionId(row.get("auctionId", Integer.class));
            domain.setPlayerGuid(row.get("playerGuid", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AuctionBidders, OutboundRow> {

        public OutboundRow convert(AuctionBidders source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAuctionId()).ifPresent(e -> row.put("auctionId", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid()).ifPresent(e -> row.put("playerGuid", Parameter.from(e)));
            return row;
        }
    }

}
