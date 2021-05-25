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
@Table("battle_pet_breed_state")
public class BattlePetBreedState {

    @Column("ID")
    private Integer id;
    @Column("BattlePetStateID")
    private Integer battlePetStateId;
    @Column("Value")
    private Integer value;
    @Column("BattlePetBreedID")
    private Integer battlePetBreedId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetBreedState> {

        public BattlePetBreedState convert(Row row) {
            BattlePetBreedState domain = new BattlePetBreedState();
            domain.setId(row.get("ID", Integer.class));
            domain.setBattlePetStateId(row.get("BattlePetStateID", Integer.class));
            domain.setValue(row.get("Value", Integer.class));
            domain.setBattlePetBreedId(row.get("BattlePetBreedID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetBreedState, OutboundRow> {

        public OutboundRow convert(BattlePetBreedState source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetStateId()).ifPresent(e -> row.put("BattlePetStateID", Parameter.from(e)));
            Optional.ofNullable(source.getValue()).ifPresent(e -> row.put("Value", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetBreedId()).ifPresent(e -> row.put("BattlePetBreedID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
