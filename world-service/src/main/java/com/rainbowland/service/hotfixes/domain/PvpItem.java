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
@Table("pvp_item")
public class PvpItem {

    @Column("ID")
    private Integer id;
    @Column("ItemID")
    private Integer itemId;
    @Column("ItemLevelDelta")
    private Integer itemLevelDelta;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PvpItem> {

        public PvpItem convert(Row row) {
            PvpItem domain = new PvpItem();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setItemLevelDelta(row.get("ItemLevelDelta", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PvpItem, OutboundRow> {

        public OutboundRow convert(PvpItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevelDelta()).ifPresent(e -> row.put("ItemLevelDelta", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
