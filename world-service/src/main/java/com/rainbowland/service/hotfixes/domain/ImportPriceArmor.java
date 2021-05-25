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
@Table("import_price_armor")
public class ImportPriceArmor {

    @Column("ID")
    private Integer id;
    @Column("ClothModifier")
    private Double clothModifier;
    @Column("LeatherModifier")
    private Double leatherModifier;
    @Column("ChainModifier")
    private Double chainModifier;
    @Column("PlateModifier")
    private Double plateModifier;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ImportPriceArmor> {

        public ImportPriceArmor convert(Row row) {
            ImportPriceArmor domain = new ImportPriceArmor();
            domain.setId(row.get("ID", Integer.class));
            domain.setClothModifier(row.get("ClothModifier", Double.class));
            domain.setLeatherModifier(row.get("LeatherModifier", Double.class));
            domain.setChainModifier(row.get("ChainModifier", Double.class));
            domain.setPlateModifier(row.get("PlateModifier", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ImportPriceArmor, OutboundRow> {

        public OutboundRow convert(ImportPriceArmor source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getClothModifier()).ifPresent(e -> row.put("ClothModifier", Parameter.from(e)));
            Optional.ofNullable(source.getLeatherModifier()).ifPresent(e -> row.put("LeatherModifier", Parameter.from(e)));
            Optional.ofNullable(source.getChainModifier()).ifPresent(e -> row.put("ChainModifier", Parameter.from(e)));
            Optional.ofNullable(source.getPlateModifier()).ifPresent(e -> row.put("PlateModifier", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
