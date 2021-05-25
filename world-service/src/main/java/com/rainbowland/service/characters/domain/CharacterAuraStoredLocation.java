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
@Table("character_aura_stored_location")
public class CharacterAuraStoredLocation {

    @Column("Guid")
    private Long guid;
    @Column("Spell")
    private Integer spell;
    @Column("MapId")
    private Integer mapId;
    @Column("PositionX")
    private Double positionX;
    @Column("PositionY")
    private Double positionY;
    @Column("PositionZ")
    private Double positionZ;
    @Column("Orientation")
    private Double orientation;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterAuraStoredLocation> {

        public CharacterAuraStoredLocation convert(Row row) {
            CharacterAuraStoredLocation domain = new CharacterAuraStoredLocation();
            domain.setGuid(row.get("Guid", Long.class));
            domain.setSpell(row.get("Spell", Integer.class));
            domain.setMapId(row.get("MapId", Integer.class));
            domain.setPositionX(row.get("PositionX", Double.class));
            domain.setPositionY(row.get("PositionY", Double.class));
            domain.setPositionZ(row.get("PositionZ", Double.class));
            domain.setOrientation(row.get("Orientation", Double.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterAuraStoredLocation, OutboundRow> {

        public OutboundRow convert(CharacterAuraStoredLocation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("Guid", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("Spell", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapId", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("PositionX", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("PositionY", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("PositionZ", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("Orientation", Parameter.from(e)));
            return row;
        }
    }

}
