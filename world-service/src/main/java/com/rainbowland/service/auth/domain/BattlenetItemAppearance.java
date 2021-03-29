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
@Table("battlenet_item_appearances")
public class BattlenetItemAppearance {

    @Column("battlenetAccountId")
    private Long battlenetAccountId;
    @Column("blobIndex")
    private Integer blobIndex;
    @Column("appearanceMask")
    private Long appearanceMask;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlenetItemAppearance> {

        public BattlenetItemAppearance convert(Row row) {
            BattlenetItemAppearance domain = new BattlenetItemAppearance();
            domain.setBattlenetAccountId(row.get("battlenetAccountId", Long.class));
            domain.setBlobIndex(row.get("blobIndex", Integer.class));
            domain.setAppearanceMask(row.get("appearanceMask", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlenetItemAppearance, OutboundRow> {

        public OutboundRow convert(BattlenetItemAppearance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getBattlenetAccountId()).ifPresent(e -> row.put("battlenetAccountId", Parameter.from(e)));
            Optional.ofNullable(source.getBlobIndex()).ifPresent(e -> row.put("blobIndex", Parameter.from(e)));
            Optional.ofNullable(source.getAppearanceMask()).ifPresent(e -> row.put("appearanceMask", Parameter.from(e)));
            return row;
        }
    }

}
