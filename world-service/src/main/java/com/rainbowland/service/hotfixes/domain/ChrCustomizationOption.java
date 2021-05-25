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
@Table("chr_customization_option")
public class ChrCustomizationOption {

    @Column("Name")
    private String name;
    @Column("ID")
    private Integer id;
    @Column("SecondaryID")
    private Integer secondaryId;
    @Column("Flags")
    private Integer flags;
    @Column("ChrModelID")
    private Integer chrModelId;
    @Column("SortIndex")
    private Integer sortIndex;
    @Column("ChrCustomizationCategoryID")
    private Integer chrCustomizationCategoryId;
    @Column("OptionType")
    private Integer optionType;
    @Column("BarberShopCostModifier")
    private Double barberShopCostModifier;
    @Column("ChrCustomizationID")
    private Integer chrCustomizationId;
    @Column("ChrCustomizationReqID")
    private Integer chrCustomizationReqId;
    @Column("UiOrderIndex")
    private Integer uiOrderIndex;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ChrCustomizationOption> {

        public ChrCustomizationOption convert(Row row) {
            ChrCustomizationOption domain = new ChrCustomizationOption();
            domain.setName(row.get("Name", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setSecondaryId(row.get("SecondaryID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setChrModelId(row.get("ChrModelID", Integer.class));
            domain.setSortIndex(row.get("SortIndex", Integer.class));
            domain.setChrCustomizationCategoryId(row.get("ChrCustomizationCategoryID", Integer.class));
            domain.setOptionType(row.get("OptionType", Integer.class));
            domain.setBarberShopCostModifier(row.get("BarberShopCostModifier", Double.class));
            domain.setChrCustomizationId(row.get("ChrCustomizationID", Integer.class));
            domain.setChrCustomizationReqId(row.get("ChrCustomizationReqID", Integer.class));
            domain.setUiOrderIndex(row.get("UiOrderIndex", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ChrCustomizationOption, OutboundRow> {

        public OutboundRow convert(ChrCustomizationOption source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSecondaryId()).ifPresent(e -> row.put("SecondaryID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getChrModelId()).ifPresent(e -> row.put("ChrModelID", Parameter.from(e)));
            Optional.ofNullable(source.getSortIndex()).ifPresent(e -> row.put("SortIndex", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationCategoryId()).ifPresent(e -> row.put("ChrCustomizationCategoryID", Parameter.from(e)));
            Optional.ofNullable(source.getOptionType()).ifPresent(e -> row.put("OptionType", Parameter.from(e)));
            Optional.ofNullable(source.getBarberShopCostModifier()).ifPresent(e -> row.put("BarberShopCostModifier", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationId()).ifPresent(e -> row.put("ChrCustomizationID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationReqId()).ifPresent(e -> row.put("ChrCustomizationReqID", Parameter.from(e)));
            Optional.ofNullable(source.getUiOrderIndex()).ifPresent(e -> row.put("UiOrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
