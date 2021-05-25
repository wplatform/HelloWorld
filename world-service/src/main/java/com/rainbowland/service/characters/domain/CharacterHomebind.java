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
@Table("character_homebind")
public class CharacterHomebind {

    @Column("guid")
    private Long guid;
    @Column("mapId")
    private Integer mapId;
    @Column("zoneId")
    private Integer zoneId;
    @Column("posX")
    private Double posX;
    @Column("posY")
    private Double posY;
    @Column("posZ")
    private Double posZ;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterHomebind> {

        public CharacterHomebind convert(Row row) {
            CharacterHomebind domain = new CharacterHomebind();
            domain.setGuid(row.get("guid", Long.class));
            domain.setMapId(row.get("mapId", Integer.class));
            domain.setZoneId(row.get("zoneId", Integer.class));
            domain.setPosX(row.get("posX", Double.class));
            domain.setPosY(row.get("posY", Double.class));
            domain.setPosZ(row.get("posZ", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterHomebind, OutboundRow> {

        public OutboundRow convert(CharacterHomebind source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("mapId", Parameter.from(e)));
            Optional.ofNullable(source.getZoneId()).ifPresent(e -> row.put("zoneId", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("posX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("posY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("posZ", Parameter.from(e)));
            return row;
        }
    }

}
