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
@Table("battle_pet_species_state")
public class BattlePetSpeciesState {

    @Column("ID")
    private Integer id;
    @Column("BattlePetStateID")
    private Integer battlePetStateId;
    @Column("Value")
    private Integer value;
    @Column("BattlePetSpeciesID")
    private Integer battlePetSpeciesId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetSpeciesState> {

        public BattlePetSpeciesState convert(Row row) {
            BattlePetSpeciesState domain = new BattlePetSpeciesState();
            domain.setId(row.get("ID", Integer.class));
            domain.setBattlePetStateId(row.get("BattlePetStateID", Integer.class));
            domain.setValue(row.get("Value", Integer.class));
            domain.setBattlePetSpeciesId(row.get("BattlePetSpeciesID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetSpeciesState, OutboundRow> {

        public OutboundRow convert(BattlePetSpeciesState source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetStateId()).ifPresent(e -> row.put("BattlePetStateID", Parameter.from(e)));
            Optional.ofNullable(source.getValue()).ifPresent(e -> row.put("Value", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetSpeciesId()).ifPresent(e -> row.put("BattlePetSpeciesID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
