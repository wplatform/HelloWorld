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
@Table("item_armor_shield")
public class ItemArmorShield {

    @Column("ID")
    private Integer id;
    @Column("Quality1")
    private Double quality1;
    @Column("Quality2")
    private Double quality2;
    @Column("Quality3")
    private Double quality3;
    @Column("Quality4")
    private Double quality4;
    @Column("Quality5")
    private Double quality5;
    @Column("Quality6")
    private Double quality6;
    @Column("Quality7")
    private Double quality7;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemArmorShield> {

        public ItemArmorShield convert(Row row) {
            ItemArmorShield domain = new ItemArmorShield();
            domain.setId(row.get("ID", Integer.class));
            domain.setQuality1(row.get("Quality1", Double.class));
            domain.setQuality2(row.get("Quality2", Double.class));
            domain.setQuality3(row.get("Quality3", Double.class));
            domain.setQuality4(row.get("Quality4", Double.class));
            domain.setQuality5(row.get("Quality5", Double.class));
            domain.setQuality6(row.get("Quality6", Double.class));
            domain.setQuality7(row.get("Quality7", Double.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemArmorShield, OutboundRow> {

        public OutboundRow convert(ItemArmorShield source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getQuality1()).ifPresent(e -> row.put("Quality1", Parameter.from(e)));
            Optional.ofNullable(source.getQuality2()).ifPresent(e -> row.put("Quality2", Parameter.from(e)));
            Optional.ofNullable(source.getQuality3()).ifPresent(e -> row.put("Quality3", Parameter.from(e)));
            Optional.ofNullable(source.getQuality4()).ifPresent(e -> row.put("Quality4", Parameter.from(e)));
            Optional.ofNullable(source.getQuality5()).ifPresent(e -> row.put("Quality5", Parameter.from(e)));
            Optional.ofNullable(source.getQuality6()).ifPresent(e -> row.put("Quality6", Parameter.from(e)));
            Optional.ofNullable(source.getQuality7()).ifPresent(e -> row.put("Quality7", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
