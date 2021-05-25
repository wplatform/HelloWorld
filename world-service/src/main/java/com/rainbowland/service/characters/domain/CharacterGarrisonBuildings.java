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
@Table("character_garrison_buildings")
public class CharacterGarrisonBuildings {

    @Column("guid")
    private Long guid;
    @Column("plotInstanceId")
    private Integer plotInstanceId;
    @Column("buildingId")
    private Integer buildingId;
    @Column("timeBuilt")
    private Long timeBuilt;
    @Column("active")
    private Integer active;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterGarrisonBuildings> {

        public CharacterGarrisonBuildings convert(Row row) {
            CharacterGarrisonBuildings domain = new CharacterGarrisonBuildings();
            domain.setGuid(row.get("guid", Long.class));
            domain.setPlotInstanceId(row.get("plotInstanceId", Integer.class));
            domain.setBuildingId(row.get("buildingId", Integer.class));
            domain.setTimeBuilt(row.get("timeBuilt", Long.class));
            domain.setActive(row.get("active", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterGarrisonBuildings, OutboundRow> {

        public OutboundRow convert(CharacterGarrisonBuildings source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getPlotInstanceId()).ifPresent(e -> row.put("plotInstanceId", Parameter.from(e)));
            Optional.ofNullable(source.getBuildingId()).ifPresent(e -> row.put("buildingId", Parameter.from(e)));
            Optional.ofNullable(source.getTimeBuilt()).ifPresent(e -> row.put("timeBuilt", Parameter.from(e)));
            Optional.ofNullable(source.getActive()).ifPresent(e -> row.put("active", Parameter.from(e)));
            return row;
        }
    }

}
