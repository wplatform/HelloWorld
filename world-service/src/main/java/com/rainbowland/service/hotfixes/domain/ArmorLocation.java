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
@Table("armor_location")
public class ArmorLocation {

    @Column("ID")
    private Integer id;
    @Column("Clothmodifier")
    private Double clothmodifier;
    @Column("Leathermodifier")
    private Double leathermodifier;
    @Column("Chainmodifier")
    private Double chainmodifier;
    @Column("Platemodifier")
    private Double platemodifier;
    @Column("Modifier")
    private Double modifier;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArmorLocation> {

        public ArmorLocation convert(Row row) {
            ArmorLocation domain = new ArmorLocation();
            domain.setId(row.get("ID", Integer.class));
            domain.setClothmodifier(row.get("Clothmodifier", Double.class));
            domain.setLeathermodifier(row.get("Leathermodifier", Double.class));
            domain.setChainmodifier(row.get("Chainmodifier", Double.class));
            domain.setPlatemodifier(row.get("Platemodifier", Double.class));
            domain.setModifier(row.get("Modifier", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArmorLocation, OutboundRow> {

        public OutboundRow convert(ArmorLocation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getClothmodifier()).ifPresent(e -> row.put("Clothmodifier", Parameter.from(e)));
            Optional.ofNullable(source.getLeathermodifier()).ifPresent(e -> row.put("Leathermodifier", Parameter.from(e)));
            Optional.ofNullable(source.getChainmodifier()).ifPresent(e -> row.put("Chainmodifier", Parameter.from(e)));
            Optional.ofNullable(source.getPlatemodifier()).ifPresent(e -> row.put("Platemodifier", Parameter.from(e)));
            Optional.ofNullable(source.getModifier()).ifPresent(e -> row.put("Modifier", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
