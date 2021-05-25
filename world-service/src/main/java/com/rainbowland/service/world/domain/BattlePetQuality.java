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
@Table("battle_pet_quality")
public class BattlePetQuality {

    @Column("speciesId")
    private Integer speciesId;
    @Column("quality")
    private Integer quality;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetQuality> {

        public BattlePetQuality convert(Row row) {
            BattlePetQuality domain = new BattlePetQuality();
            domain.setSpeciesId(row.get("speciesId", Integer.class));
            domain.setQuality(row.get("quality", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetQuality, OutboundRow> {

        public OutboundRow convert(BattlePetQuality source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpeciesId()).ifPresent(e -> row.put("speciesId", Parameter.from(e)));
            Optional.ofNullable(source.getQuality()).ifPresent(e -> row.put("quality", Parameter.from(e)));
            return row;
        }
    }

}
