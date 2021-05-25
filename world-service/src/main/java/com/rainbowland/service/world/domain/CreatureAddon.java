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
@Table("creature_addon")
public class CreatureAddon {

    @Column("guid")
    private Long guid;
    @Column("path_id")
    private Integer pathId;
    @Column("mount")
    private Integer mount;
    @Column("bytes1")
    private Integer bytes1;
    @Column("bytes2")
    private Integer bytes2;
    @Column("emote")
    private Integer emote;
    @Column("aiAnimKit")
    private Integer aiAnimKit;
    @Column("movementAnimKit")
    private Integer movementAnimKit;
    @Column("meleeAnimKit")
    private Integer meleeAnimKit;
    @Column("visibilityDistanceType")
    private Integer visibilityDistanceType;
    @Column("auras")
    private String auras;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureAddon> {

        public CreatureAddon convert(Row row) {
            CreatureAddon domain = new CreatureAddon();
            domain.setGuid(row.get("guid", Long.class));
            domain.setPathId(row.get("path_id", Integer.class));
            domain.setMount(row.get("mount", Integer.class));
            domain.setBytes1(row.get("bytes1", Integer.class));
            domain.setBytes2(row.get("bytes2", Integer.class));
            domain.setEmote(row.get("emote", Integer.class));
            domain.setAiAnimKit(row.get("aiAnimKit", Integer.class));
            domain.setMovementAnimKit(row.get("movementAnimKit", Integer.class));
            domain.setMeleeAnimKit(row.get("meleeAnimKit", Integer.class));
            domain.setVisibilityDistanceType(row.get("visibilityDistanceType", Integer.class));
            domain.setAuras(row.get("auras", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureAddon, OutboundRow> {

        public OutboundRow convert(CreatureAddon source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getPathId()).ifPresent(e -> row.put("path_id", Parameter.from(e)));
            Optional.ofNullable(source.getMount()).ifPresent(e -> row.put("mount", Parameter.from(e)));
            Optional.ofNullable(source.getBytes1()).ifPresent(e -> row.put("bytes1", Parameter.from(e)));
            Optional.ofNullable(source.getBytes2()).ifPresent(e -> row.put("bytes2", Parameter.from(e)));
            Optional.ofNullable(source.getEmote()).ifPresent(e -> row.put("emote", Parameter.from(e)));
            Optional.ofNullable(source.getAiAnimKit()).ifPresent(e -> row.put("aiAnimKit", Parameter.from(e)));
            Optional.ofNullable(source.getMovementAnimKit()).ifPresent(e -> row.put("movementAnimKit", Parameter.from(e)));
            Optional.ofNullable(source.getMeleeAnimKit()).ifPresent(e -> row.put("meleeAnimKit", Parameter.from(e)));
            Optional.ofNullable(source.getVisibilityDistanceType()).ifPresent(e -> row.put("visibilityDistanceType", Parameter.from(e)));
            Optional.ofNullable(source.getAuras()).ifPresent(e -> row.put("auras", Parameter.from(e)));
            return row;
        }
    }

}
