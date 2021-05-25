package com.rainbowland.service.world.domain;

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
@Table("garrison_follower_class_spec_abilities")
public class GarrisonFollowerClassSpecAbilities {

    @Column("classSpecId")
    private Integer classSpecId;
    @Column("abilityId")
    private Integer abilityId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrisonFollowerClassSpecAbilities> {

        public GarrisonFollowerClassSpecAbilities convert(Row row) {
            GarrisonFollowerClassSpecAbilities domain = new GarrisonFollowerClassSpecAbilities();
            domain.setClassSpecId(row.get("classSpecId", Integer.class));
            domain.setAbilityId(row.get("abilityId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrisonFollowerClassSpecAbilities, OutboundRow> {

        public OutboundRow convert(GarrisonFollowerClassSpecAbilities source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getClassSpecId()).ifPresent(e -> row.put("classSpecId", Parameter.from(e)));
            Optional.ofNullable(source.getAbilityId()).ifPresent(e -> row.put("abilityId", Parameter.from(e)));
            return row;
        }
    }

}
