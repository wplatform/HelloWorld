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
@Table("transport_rotation")
public class TransportRotation {

    @Column("ID")
    private Integer id;
    @Column("Rot1")
    private Double rot1;
    @Column("Rot2")
    private Double rot2;
    @Column("Rot3")
    private Double rot3;
    @Column("Rot4")
    private Double rot4;
    @Column("TimeIndex")
    private Integer timeIndex;
    @Column("GameObjectsID")
    private Integer gameObjectsId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TransportRotation> {

        public TransportRotation convert(Row row) {
            TransportRotation domain = new TransportRotation();
            domain.setId(row.get("ID", Integer.class));
            domain.setRot1(row.get("Rot1", Double.class));
            domain.setRot2(row.get("Rot2", Double.class));
            domain.setRot3(row.get("Rot3", Double.class));
            domain.setRot4(row.get("Rot4", Double.class));
            domain.setTimeIndex(row.get("TimeIndex", Integer.class));
            domain.setGameObjectsId(row.get("GameObjectsID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TransportRotation, OutboundRow> {

        public OutboundRow convert(TransportRotation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRot1()).ifPresent(e -> row.put("Rot1", Parameter.from(e)));
            Optional.ofNullable(source.getRot2()).ifPresent(e -> row.put("Rot2", Parameter.from(e)));
            Optional.ofNullable(source.getRot3()).ifPresent(e -> row.put("Rot3", Parameter.from(e)));
            Optional.ofNullable(source.getRot4()).ifPresent(e -> row.put("Rot4", Parameter.from(e)));
            Optional.ofNullable(source.getTimeIndex()).ifPresent(e -> row.put("TimeIndex", Parameter.from(e)));
            Optional.ofNullable(source.getGameObjectsId()).ifPresent(e -> row.put("GameObjectsID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
