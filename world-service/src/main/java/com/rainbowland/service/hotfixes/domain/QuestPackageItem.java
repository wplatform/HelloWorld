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
@Table("quest_package_item")
public class QuestPackageItem {

    @Column("ID")
    private Integer id;
    @Column("PackageID")
    private Integer packageId;
    @Column("ItemID")
    private Integer itemId;
    @Column("ItemQuantity")
    private Integer itemQuantity;
    @Column("DisplayType")
    private Integer displayType;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, QuestPackageItem> {

        public QuestPackageItem convert(Row row) {
            QuestPackageItem domain = new QuestPackageItem();
            domain.setId(row.get("ID", Integer.class));
            domain.setPackageId(row.get("PackageID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setItemQuantity(row.get("ItemQuantity", Integer.class));
            domain.setDisplayType(row.get("DisplayType", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<QuestPackageItem, OutboundRow> {

        public OutboundRow convert(QuestPackageItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPackageId()).ifPresent(e -> row.put("PackageID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getItemQuantity()).ifPresent(e -> row.put("ItemQuantity", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayType()).ifPresent(e -> row.put("DisplayType", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
