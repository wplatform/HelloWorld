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
@Table("item_instance_gems")
public class ItemInstanceGems {

    @Column("itemGuid")
    private Long itemGuid;
    @Column("gemItemId1")
    private Integer gemItemId1;
    @Column("gemBonuses1")
    private String gemBonuses1;
    @Column("gemContext1")
    private Integer gemContext1;
    @Column("gemScalingLevel1")
    private Integer gemScalingLevel1;
    @Column("gemItemId2")
    private Integer gemItemId2;
    @Column("gemBonuses2")
    private String gemBonuses2;
    @Column("gemContext2")
    private Integer gemContext2;
    @Column("gemScalingLevel2")
    private Integer gemScalingLevel2;
    @Column("gemItemId3")
    private Integer gemItemId3;
    @Column("gemBonuses3")
    private String gemBonuses3;
    @Column("gemContext3")
    private Integer gemContext3;
    @Column("gemScalingLevel3")
    private Integer gemScalingLevel3;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstanceGems> {

        public ItemInstanceGems convert(Row row) {
            ItemInstanceGems domain = new ItemInstanceGems();
            domain.setItemGuid(row.get("itemGuid", Long.class));
            domain.setGemItemId1(row.get("gemItemId1", Integer.class));
            domain.setGemBonuses1(row.get("gemBonuses1", String.class));
            domain.setGemContext1(row.get("gemContext1", Integer.class));
            domain.setGemScalingLevel1(row.get("gemScalingLevel1", Integer.class));
            domain.setGemItemId2(row.get("gemItemId2", Integer.class));
            domain.setGemBonuses2(row.get("gemBonuses2", String.class));
            domain.setGemContext2(row.get("gemContext2", Integer.class));
            domain.setGemScalingLevel2(row.get("gemScalingLevel2", Integer.class));
            domain.setGemItemId3(row.get("gemItemId3", Integer.class));
            domain.setGemBonuses3(row.get("gemBonuses3", String.class));
            domain.setGemContext3(row.get("gemContext3", Integer.class));
            domain.setGemScalingLevel3(row.get("gemScalingLevel3", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstanceGems, OutboundRow> {

        public OutboundRow convert(ItemInstanceGems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("itemGuid", Parameter.from(e)));
            Optional.ofNullable(source.getGemItemId1()).ifPresent(e -> row.put("gemItemId1", Parameter.from(e)));
            Optional.ofNullable(source.getGemBonuses1()).ifPresent(e -> row.put("gemBonuses1", Parameter.from(e)));
            Optional.ofNullable(source.getGemContext1()).ifPresent(e -> row.put("gemContext1", Parameter.from(e)));
            Optional.ofNullable(source.getGemScalingLevel1()).ifPresent(e -> row.put("gemScalingLevel1", Parameter.from(e)));
            Optional.ofNullable(source.getGemItemId2()).ifPresent(e -> row.put("gemItemId2", Parameter.from(e)));
            Optional.ofNullable(source.getGemBonuses2()).ifPresent(e -> row.put("gemBonuses2", Parameter.from(e)));
            Optional.ofNullable(source.getGemContext2()).ifPresent(e -> row.put("gemContext2", Parameter.from(e)));
            Optional.ofNullable(source.getGemScalingLevel2()).ifPresent(e -> row.put("gemScalingLevel2", Parameter.from(e)));
            Optional.ofNullable(source.getGemItemId3()).ifPresent(e -> row.put("gemItemId3", Parameter.from(e)));
            Optional.ofNullable(source.getGemBonuses3()).ifPresent(e -> row.put("gemBonuses3", Parameter.from(e)));
            Optional.ofNullable(source.getGemContext3()).ifPresent(e -> row.put("gemContext3", Parameter.from(e)));
            Optional.ofNullable(source.getGemScalingLevel3()).ifPresent(e -> row.put("gemScalingLevel3", Parameter.from(e)));
            return row;
        }
    }

}
