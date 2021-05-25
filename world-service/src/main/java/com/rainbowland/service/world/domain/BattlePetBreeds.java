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
@Table("battle_pet_breeds")
public class BattlePetBreeds {

    @Column("speciesId")
    private Integer speciesId;
    @Column("breedId")
    private Integer breedId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetBreeds> {

        public BattlePetBreeds convert(Row row) {
            BattlePetBreeds domain = new BattlePetBreeds();
            domain.setSpeciesId(row.get("speciesId", Integer.class));
            domain.setBreedId(row.get("breedId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetBreeds, OutboundRow> {

        public OutboundRow convert(BattlePetBreeds source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpeciesId()).ifPresent(e -> row.put("speciesId", Parameter.from(e)));
            Optional.ofNullable(source.getBreedId()).ifPresent(e -> row.put("breedId", Parameter.from(e)));
            return row;
        }
    }

}
