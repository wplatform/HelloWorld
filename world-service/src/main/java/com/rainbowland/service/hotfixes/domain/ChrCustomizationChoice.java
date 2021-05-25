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
@Table("chr_customization_choice")
public class ChrCustomizationChoice {

    @Column("Name")
    private String name;
    @Column("ID")
    private Integer id;
    @Column("ChrCustomizationOptionID")
    private Integer chrCustomizationOptionId;
    @Column("ChrCustomizationReqID")
    private Integer chrCustomizationReqId;
    @Column("SortOrder")
    private Integer sortOrder;
    @Column("SwatchColor1")
    private Integer swatchColor1;
    @Column("SwatchColor2")
    private Integer swatchColor2;
    @Column("UiOrderIndex")
    private Integer uiOrderIndex;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrCustomizationChoice> {

        public ChrCustomizationChoice convert(Row row) {
            ChrCustomizationChoice domain = new ChrCustomizationChoice();
            domain.setName(row.get("Name", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setChrCustomizationOptionId(row.get("ChrCustomizationOptionID", Integer.class));
            domain.setChrCustomizationReqId(row.get("ChrCustomizationReqID", Integer.class));
            domain.setSortOrder(row.get("SortOrder", Integer.class));
            domain.setSwatchColor1(row.get("SwatchColor1", Integer.class));
            domain.setSwatchColor2(row.get("SwatchColor2", Integer.class));
            domain.setUiOrderIndex(row.get("UiOrderIndex", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrCustomizationChoice, OutboundRow> {

        public OutboundRow convert(ChrCustomizationChoice source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationOptionId()).ifPresent(e -> row.put("ChrCustomizationOptionID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationReqId()).ifPresent(e -> row.put("ChrCustomizationReqID", Parameter.from(e)));
            Optional.ofNullable(source.getSortOrder()).ifPresent(e -> row.put("SortOrder", Parameter.from(e)));
            Optional.ofNullable(source.getSwatchColor1()).ifPresent(e -> row.put("SwatchColor1", Parameter.from(e)));
            Optional.ofNullable(source.getSwatchColor2()).ifPresent(e -> row.put("SwatchColor2", Parameter.from(e)));
            Optional.ofNullable(source.getUiOrderIndex()).ifPresent(e -> row.put("UiOrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
