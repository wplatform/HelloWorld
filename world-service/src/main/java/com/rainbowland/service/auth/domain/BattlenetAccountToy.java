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
@Table("battlenet_account_toys")
public class BattlenetAccountToy {

    @Column("accountId")
    private Long accountId;
    @Column("itemId")
    private Long itemId;
    @Column("isFavourite")
    private Integer isFavourite;
    @Column("hasFanfare")
    private Integer hasFanfare;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlenetAccountToy> {

        public BattlenetAccountToy convert(Row row) {
            BattlenetAccountToy domain = new BattlenetAccountToy();
            domain.setAccountId(row.get("accountId", Long.class));
            domain.setItemId(row.get("itemId", Long.class));
            domain.setIsFavourite(row.get("isFavourite", Integer.class));
            domain.setHasFanfare(row.get("hasFanfare", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlenetAccountToy, OutboundRow> {

        public OutboundRow convert(BattlenetAccountToy source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("accountId", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("itemId", Parameter.from(e)));
            Optional.ofNullable(source.getIsFavourite()).ifPresent(e -> row.put("isFavourite", Parameter.from(e)));
            Optional.ofNullable(source.getHasFanfare()).ifPresent(e -> row.put("hasFanfare", Parameter.from(e)));
            return row;
        }
    }

}
