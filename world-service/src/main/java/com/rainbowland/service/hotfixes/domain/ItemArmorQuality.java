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
@Table("item_armor_quality")
public class ItemArmorQuality {

    @Column("ID")
    private Integer id;
    @Column("Qualitymod1")
    private Double qualitymod1;
    @Column("Qualitymod2")
    private Double qualitymod2;
    @Column("Qualitymod3")
    private Double qualitymod3;
    @Column("Qualitymod4")
    private Double qualitymod4;
    @Column("Qualitymod5")
    private Double qualitymod5;
    @Column("Qualitymod6")
    private Double qualitymod6;
    @Column("Qualitymod7")
    private Double qualitymod7;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemArmorQuality> {

        public ItemArmorQuality convert(Row row) {
            ItemArmorQuality domain = new ItemArmorQuality();
            domain.setId(row.get("ID", Integer.class));
            domain.setQualitymod1(row.get("Qualitymod1", Double.class));
            domain.setQualitymod2(row.get("Qualitymod2", Double.class));
            domain.setQualitymod3(row.get("Qualitymod3", Double.class));
            domain.setQualitymod4(row.get("Qualitymod4", Double.class));
            domain.setQualitymod5(row.get("Qualitymod5", Double.class));
            domain.setQualitymod6(row.get("Qualitymod6", Double.class));
            domain.setQualitymod7(row.get("Qualitymod7", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemArmorQuality, OutboundRow> {

        public OutboundRow convert(ItemArmorQuality source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getQualitymod1()).ifPresent(e -> row.put("Qualitymod1", Parameter.from(e)));
            Optional.ofNullable(source.getQualitymod2()).ifPresent(e -> row.put("Qualitymod2", Parameter.from(e)));
            Optional.ofNullable(source.getQualitymod3()).ifPresent(e -> row.put("Qualitymod3", Parameter.from(e)));
            Optional.ofNullable(source.getQualitymod4()).ifPresent(e -> row.put("Qualitymod4", Parameter.from(e)));
            Optional.ofNullable(source.getQualitymod5()).ifPresent(e -> row.put("Qualitymod5", Parameter.from(e)));
            Optional.ofNullable(source.getQualitymod6()).ifPresent(e -> row.put("Qualitymod6", Parameter.from(e)));
            Optional.ofNullable(source.getQualitymod7()).ifPresent(e -> row.put("Qualitymod7", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
