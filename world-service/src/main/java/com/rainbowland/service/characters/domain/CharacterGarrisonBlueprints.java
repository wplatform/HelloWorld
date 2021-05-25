package com.rainbowland.service.characters.domain;

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
@Table("character_garrison_blueprints")
public class CharacterGarrisonBlueprints {

    @Column("guid")
    private Long guid;
    @Column("buildingId")
    private Integer buildingId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterGarrisonBlueprints> {

        public CharacterGarrisonBlueprints convert(Row row) {
            CharacterGarrisonBlueprints domain = new CharacterGarrisonBlueprints();
            domain.setGuid(row.get("guid", Long.class));
            domain.setBuildingId(row.get("buildingId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterGarrisonBlueprints, OutboundRow> {

        public OutboundRow convert(CharacterGarrisonBlueprints source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getBuildingId()).ifPresent(e -> row.put("buildingId", Parameter.from(e)));
            return row;
        }
    }

}
