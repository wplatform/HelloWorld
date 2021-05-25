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
@Table("item_armor_total")
public class ItemArmorTotal {

    @Column("ID")
    private Integer id;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("Cloth")
    private Double cloth;
    @Column("Leather")
    private Double leather;
    @Column("Mail")
    private Double mail;
    @Column("Plate")
    private Double plate;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemArmorTotal> {

        public ItemArmorTotal convert(Row row) {
            ItemArmorTotal domain = new ItemArmorTotal();
            domain.setId(row.get("ID", Integer.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setCloth(row.get("Cloth", Double.class));
            domain.setLeather(row.get("Leather", Double.class));
            domain.setMail(row.get("Mail", Double.class));
            domain.setPlate(row.get("Plate", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemArmorTotal, OutboundRow> {

        public OutboundRow convert(ItemArmorTotal source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getCloth()).ifPresent(e -> row.put("Cloth", Parameter.from(e)));
            Optional.ofNullable(source.getLeather()).ifPresent(e -> row.put("Leather", Parameter.from(e)));
            Optional.ofNullable(source.getMail()).ifPresent(e -> row.put("Mail", Parameter.from(e)));
            Optional.ofNullable(source.getPlate()).ifPresent(e -> row.put("Plate", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
