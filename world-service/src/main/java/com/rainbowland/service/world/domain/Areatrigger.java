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
@Table("areatrigger")
public class Areatrigger {

    @Column("SpawnId")
    private Long spawnId;
    @Column("AreaTriggerId")
    private Integer areaTriggerId;
    @Column("IsServerSide")
    private Integer isServerSide;
    @Column("MapId")
    private Integer mapId;
    @Column("PosX")
    private Double posX;
    @Column("PosY")
    private Double posY;
    @Column("PosZ")
    private Double posZ;
    @Column("Orientation")
    private Double orientation;
    @Column("PhaseUseFlags")
    private Integer phaseUseFlags;
    @Column("PhaseId")
    private Integer phaseId;
    @Column("PhaseGroup")
    private Integer phaseGroup;
    @Column("Comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Areatrigger> {

        public Areatrigger convert(Row row) {
            Areatrigger domain = new Areatrigger();
            domain.setSpawnId(row.get("SpawnId", Long.class));
            domain.setAreaTriggerId(row.get("AreaTriggerId", Integer.class));
            domain.setIsServerSide(row.get("IsServerSide", Integer.class));
            domain.setMapId(row.get("MapId", Integer.class));
            domain.setPosX(row.get("PosX", Double.class));
            domain.setPosY(row.get("PosY", Double.class));
            domain.setPosZ(row.get("PosZ", Double.class));
            domain.setOrientation(row.get("Orientation", Double.class));
            domain.setPhaseUseFlags(row.get("PhaseUseFlags", Integer.class));
            domain.setPhaseId(row.get("PhaseId", Integer.class));
            domain.setPhaseGroup(row.get("PhaseGroup", Integer.class));
            domain.setComment(row.get("Comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Areatrigger, OutboundRow> {

        public OutboundRow convert(Areatrigger source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSpawnId()).ifPresent(e -> row.put("SpawnId", Parameter.from(e)));
            Optional.ofNullable(source.getAreaTriggerId()).ifPresent(e -> row.put("AreaTriggerId", Parameter.from(e)));
            Optional.ofNullable(source.getIsServerSide()).ifPresent(e -> row.put("IsServerSide", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("MapId", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("PosX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("PosY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("PosZ", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("Orientation", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseUseFlags()).ifPresent(e -> row.put("PhaseUseFlags", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseId()).ifPresent(e -> row.put("PhaseId", Parameter.from(e)));
            Optional.ofNullable(source.getPhaseGroup()).ifPresent(e -> row.put("PhaseGroup", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("Comment", Parameter.from(e)));
            return row;
        }
    }

}
