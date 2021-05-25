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
@Table("azerite_item_milestone_power")
public class AzeriteItemMilestonePower {

    @Column("ID")
    private Integer id;
    @Column("RequiredLevel")
    private Integer requiredLevel;
    @Column("AzeritePowerID")
    private Integer azeritePowerId;
    @Column("Type")
    private Integer type;
    @Column("AutoUnlock")
    private Integer autoUnlock;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteItemMilestonePower> {

        public AzeriteItemMilestonePower convert(Row row) {
            AzeriteItemMilestonePower domain = new AzeriteItemMilestonePower();
            domain.setId(row.get("ID", Integer.class));
            domain.setRequiredLevel(row.get("RequiredLevel", Integer.class));
            domain.setAzeritePowerId(row.get("AzeritePowerID", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setAutoUnlock(row.get("AutoUnlock", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteItemMilestonePower, OutboundRow> {

        public OutboundRow convert(AzeriteItemMilestonePower source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredLevel()).ifPresent(e -> row.put("RequiredLevel", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerId()).ifPresent(e -> row.put("AzeritePowerID", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getAutoUnlock()).ifPresent(e -> row.put("AutoUnlock", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
