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
@Table("azerite_empowered_item")
public class AzeriteEmpoweredItem {

    @Column("ID")
    private Integer id;
    @Column("ItemID")
    private Integer itemId;
    @Column("AzeriteTierUnlockSetID")
    private Integer azeriteTierUnlockSetId;
    @Column("AzeritePowerSetID")
    private Integer azeritePowerSetId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteEmpoweredItem> {

        public AzeriteEmpoweredItem convert(Row row) {
            AzeriteEmpoweredItem domain = new AzeriteEmpoweredItem();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId(row.get("ItemID", Integer.class));
            domain.setAzeriteTierUnlockSetId(row.get("AzeriteTierUnlockSetID", Integer.class));
            domain.setAzeritePowerSetId(row.get("AzeritePowerSetID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteEmpoweredItem, OutboundRow> {

        public OutboundRow convert(AzeriteEmpoweredItem source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId()).ifPresent(e -> row.put("ItemID", Parameter.from(e)));
            Optional.ofNullable(source.getAzeriteTierUnlockSetId()).ifPresent(e -> row.put("AzeriteTierUnlockSetID", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerSetId()).ifPresent(e -> row.put("AzeritePowerSetID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
