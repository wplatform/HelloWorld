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
@Table("transport_animation")
public class TransportAnimation {

    @Column("ID")
    private Integer id;
    @Column("PosX")
    private Double posX;
    @Column("PosY")
    private Double posY;
    @Column("PosZ")
    private Double posZ;
    @Column("SequenceID")
    private Integer sequenceId;
    @Column("TimeIndex")
    private Integer timeIndex;
    @Column("TransportID")
    private Integer transportId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TransportAnimation> {

        public TransportAnimation convert(Row row) {
            TransportAnimation domain = new TransportAnimation();
            domain.setId(row.get("ID", Integer.class));
            domain.setPosX(row.get("PosX", Double.class));
            domain.setPosY(row.get("PosY", Double.class));
            domain.setPosZ(row.get("PosZ", Double.class));
            domain.setSequenceId(row.get("SequenceID", Integer.class));
            domain.setTimeIndex(row.get("TimeIndex", Integer.class));
            domain.setTransportId(row.get("TransportID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TransportAnimation, OutboundRow> {

        public OutboundRow convert(TransportAnimation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("PosX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("PosY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("PosZ", Parameter.from(e)));
            Optional.ofNullable(source.getSequenceId()).ifPresent(e -> row.put("SequenceID", Parameter.from(e)));
            Optional.ofNullable(source.getTimeIndex()).ifPresent(e -> row.put("TimeIndex", Parameter.from(e)));
            Optional.ofNullable(source.getTransportId()).ifPresent(e -> row.put("TransportID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
