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
@Table("spell_category")
public class SpellCategory {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("Flags")
    private Integer flags;
    @Column("UsesPerWeek")
    private Integer usesPerWeek;
    @Column("MaxCharges")
    private Integer maxCharges;
    @Column("ChargeRecoveryTime")
    private Integer chargeRecoveryTime;
    @Column("TypeMask")
    private Integer typeMask;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellCategory> {

        public SpellCategory convert(Row row) {
            SpellCategory domain = new SpellCategory();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setUsesPerWeek(row.get("UsesPerWeek", Integer.class));
            domain.setMaxCharges(row.get("MaxCharges", Integer.class));
            domain.setChargeRecoveryTime(row.get("ChargeRecoveryTime", Integer.class));
            domain.setTypeMask(row.get("TypeMask", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellCategory, OutboundRow> {

        public OutboundRow convert(SpellCategory source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getUsesPerWeek()).ifPresent(e -> row.put("UsesPerWeek", Parameter.from(e)));
            Optional.ofNullable(source.getMaxCharges()).ifPresent(e -> row.put("MaxCharges", Parameter.from(e)));
            Optional.ofNullable(source.getChargeRecoveryTime()).ifPresent(e -> row.put("ChargeRecoveryTime", Parameter.from(e)));
            Optional.ofNullable(source.getTypeMask()).ifPresent(e -> row.put("TypeMask", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
