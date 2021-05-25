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
@Table("chr_customization_display_info")
public class ChrCustomizationDisplayInfo {

    @Column("ID")
    private Integer id;
    @Column("ShapeshiftFormID")
    private Integer shapeshiftFormId;
    @Column("DisplayID")
    private Integer displayId;
    @Column("BarberShopMinCameraDistance")
    private Double barberShopMinCameraDistance;
    @Column("BarberShopHeightOffset")
    private Double barberShopHeightOffset;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrCustomizationDisplayInfo> {

        public ChrCustomizationDisplayInfo convert(Row row) {
            ChrCustomizationDisplayInfo domain = new ChrCustomizationDisplayInfo();
            domain.setId(row.get("ID", Integer.class));
            domain.setShapeshiftFormId(row.get("ShapeshiftFormID", Integer.class));
            domain.setDisplayId(row.get("DisplayID", Integer.class));
            domain.setBarberShopMinCameraDistance(row.get("BarberShopMinCameraDistance", Double.class));
            domain.setBarberShopHeightOffset(row.get("BarberShopHeightOffset", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrCustomizationDisplayInfo, OutboundRow> {

        public OutboundRow convert(ChrCustomizationDisplayInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getShapeshiftFormId()).ifPresent(e -> row.put("ShapeshiftFormID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId()).ifPresent(e -> row.put("DisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getBarberShopMinCameraDistance()).ifPresent(e -> row.put("BarberShopMinCameraDistance", Parameter.from(e)));
            Optional.ofNullable(source.getBarberShopHeightOffset()).ifPresent(e -> row.put("BarberShopHeightOffset", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
