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
@Table("transmog_set_item")
public class TransmogSetItem {

    @Column("ID")
    private Integer id;
    @Column("TransmogSetID")
    private Integer transmogSetId;
    @Column("ItemModifiedAppearanceID")
    private Integer itemModifiedAppearanceId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TransmogSetItem> {

        public TransmogSetItem convert(Row row) {
            TransmogSetItem domain = new TransmogSetItem();
            domain.setId(row.get("ID", Integer.class));
            domain.setTransmogSetId(row.get("TransmogSetID", Integer.class));
            domain.setItemModifiedAppearanceId(row.get("ItemModifiedAppearanceID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TransmogSetItem, OutboundRow> {

        public OutboundRow convert(TransmogSetItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogSetId()).ifPresent(e -> row.put("TransmogSetID", Parameter.from(e)));
            Optional.ofNullable(source.getItemModifiedAppearanceId()).ifPresent(e -> row.put("ItemModifiedAppearanceID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
