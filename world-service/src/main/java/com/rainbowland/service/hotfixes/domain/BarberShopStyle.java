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
@Table("barber_shop_style")
public class BarberShopStyle {

    @Column("DisplayName")
    private String displayName;
    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("Type")
    private Integer type;
    @Column("CostModifier")
    private Double costModifier;
    @Column("Race")
    private Integer race;
    @Column("Sex")
    private Integer sex;
    @Column("Data")
    private Integer data;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BarberShopStyle> {

        public BarberShopStyle convert(Row row) {
            BarberShopStyle domain = new BarberShopStyle();
            domain.setDisplayName(row.get("DisplayName", String.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setCostModifier(row.get("CostModifier", Double.class));
            domain.setRace(row.get("Race", Integer.class));
            domain.setSex(row.get("Sex", Integer.class));
            domain.setData(row.get("Data", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BarberShopStyle, OutboundRow> {

        public OutboundRow convert(BarberShopStyle source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDisplayName()).ifPresent(e -> row.put("DisplayName", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getCostModifier()).ifPresent(e -> row.put("CostModifier", Parameter.from(e)));
            Optional.ofNullable(source.getRace()).ifPresent(e -> row.put("Race", Parameter.from(e)));
            Optional.ofNullable(source.getSex()).ifPresent(e -> row.put("Sex", Parameter.from(e)));
            Optional.ofNullable(source.getData()).ifPresent(e -> row.put("Data", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
