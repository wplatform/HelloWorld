package com.rainbowland.service.auth.domain;

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
@Table("battlenet_account_heirlooms")
public class BattlenetAccountHeirloom {

    @Column("accountId")
    private Long accountId;
    @Column("itemId")
    private Long itemId;
    @Column("flags")
    private Integer flags;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlenetAccountHeirloom> {

        public BattlenetAccountHeirloom convert(Row row) {
            BattlenetAccountHeirloom domain = new BattlenetAccountHeirloom();
            domain.setAccountId(row.get("accountId", Long.class));
            domain.setItemId(row.get("itemId", Long.class));
            domain.setFlags(row.get("flags", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlenetAccountHeirloom, OutboundRow> {

        public OutboundRow convert(BattlenetAccountHeirloom source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("accountId", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("itemId", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            return row;
        }
    }

}
