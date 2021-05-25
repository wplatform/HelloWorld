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
@Table("corpse")
public class Corpse {

    @Column("guid")
    private Long guid;
    @Column("posX")
    private Double posX;
    @Column("posY")
    private Double posY;
    @Column("posZ")
    private Double posZ;
    @Column("orientation")
    private Double orientation;
    @Column("mapId")
    private Integer mapId;
    @Column("displayId")
    private Integer displayId;
    @Column("itemCache")
    private String itemCache;
    @Column("race")
    private Integer race;
    @Column("class")
    private Integer klass;
    @Column("gender")
    private Integer gender;
    @Column("flags")
    private Integer flags;
    @Column("dynFlags")
    private Integer dynFlags;
    @Column("time")
    private Integer time;
    @Column("corpseType")
    private Integer corpseType;
    @Column("instanceId")
    private Integer instanceId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Corpse> {

        public Corpse convert(Row row) {
            Corpse domain = new Corpse();
            domain.setGuid(row.get("guid", Long.class));
            domain.setPosX(row.get("posX", Double.class));
            domain.setPosY(row.get("posY", Double.class));
            domain.setPosZ(row.get("posZ", Double.class));
            domain.setOrientation(row.get("orientation", Double.class));
            domain.setMapId(row.get("mapId", Integer.class));
            domain.setDisplayId(row.get("displayId", Integer.class));
            domain.setItemCache(row.get("itemCache", String.class));
            domain.setRace(row.get("race", Integer.class));
            domain.setKlass(row.get("class", Integer.class));
            domain.setGender(row.get("gender", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setDynFlags(row.get("dynFlags", Integer.class));
            domain.setTime(row.get("time", Integer.class));
            domain.setCorpseType(row.get("corpseType", Integer.class));
            domain.setInstanceId(row.get("instanceId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Corpse, OutboundRow> {

        public OutboundRow convert(Corpse source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("posX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("posY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("posZ", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("mapId", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId()).ifPresent(e -> row.put("displayId", Parameter.from(e)));
            Optional.ofNullable(source.getItemCache()).ifPresent(e -> row.put("itemCache", Parameter.from(e)));
            Optional.ofNullable(source.getRace()).ifPresent(e -> row.put("race", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("class", Parameter.from(e)));
            Optional.ofNullable(source.getGender()).ifPresent(e -> row.put("gender", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getDynFlags()).ifPresent(e -> row.put("dynFlags", Parameter.from(e)));
            Optional.ofNullable(source.getTime()).ifPresent(e -> row.put("time", Parameter.from(e)));
            Optional.ofNullable(source.getCorpseType()).ifPresent(e -> row.put("corpseType", Parameter.from(e)));
            Optional.ofNullable(source.getInstanceId()).ifPresent(e -> row.put("instanceId", Parameter.from(e)));
            return row;
        }
    }

}
