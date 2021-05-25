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
@Table("gm_complaint")
public class GmComplaint {

    @Column("id")
    private Integer id;
    @Column("playerGuid")
    private Long playerGuid;
    @Column("note")
    private String note;
    @Column("createTime")
    private Long createTime;
    @Column("mapId")
    private Integer mapId;
    @Column("posX")
    private Double posX;
    @Column("posY")
    private Double posY;
    @Column("posZ")
    private Double posZ;
    @Column("facing")
    private Double facing;
    @Column("targetCharacterGuid")
    private Long targetCharacterGuid;
    @Column("complaintType")
    private Integer complaintType;
    @Column("reportLineIndex")
    private Integer reportLineIndex;
    @Column("closedBy")
    private Long closedBy;
    @Column("assignedTo")
    private Long assignedTo;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GmComplaint> {

        public GmComplaint convert(Row row) {
            GmComplaint domain = new GmComplaint();
            domain.setId(row.get("id", Integer.class));
            domain.setPlayerGuid(row.get("playerGuid", Long.class));
            domain.setNote(row.get("note", String.class));
            domain.setCreateTime(row.get("createTime", Long.class));
            domain.setMapId(row.get("mapId", Integer.class));
            domain.setPosX(row.get("posX", Double.class));
            domain.setPosY(row.get("posY", Double.class));
            domain.setPosZ(row.get("posZ", Double.class));
            domain.setFacing(row.get("facing", Double.class));
            domain.setTargetCharacterGuid(row.get("targetCharacterGuid", Long.class));
            domain.setComplaintType(row.get("complaintType", Integer.class));
            domain.setReportLineIndex(row.get("reportLineIndex", Integer.class));
            domain.setClosedBy(row.get("closedBy", Long.class));
            domain.setAssignedTo(row.get("assignedTo", Long.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GmComplaint, OutboundRow> {

        public OutboundRow convert(GmComplaint source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerGuid()).ifPresent(e -> row.put("playerGuid", Parameter.from(e)));
            Optional.ofNullable(source.getNote()).ifPresent(e -> row.put("note", Parameter.from(e)));
            Optional.ofNullable(source.getCreateTime()).ifPresent(e -> row.put("createTime", Parameter.from(e)));
            Optional.ofNullable(source.getMapId()).ifPresent(e -> row.put("mapId", Parameter.from(e)));
            Optional.ofNullable(source.getPosX()).ifPresent(e -> row.put("posX", Parameter.from(e)));
            Optional.ofNullable(source.getPosY()).ifPresent(e -> row.put("posY", Parameter.from(e)));
            Optional.ofNullable(source.getPosZ()).ifPresent(e -> row.put("posZ", Parameter.from(e)));
            Optional.ofNullable(source.getFacing()).ifPresent(e -> row.put("facing", Parameter.from(e)));
            Optional.ofNullable(source.getTargetCharacterGuid()).ifPresent(e -> row.put("targetCharacterGuid", Parameter.from(e)));
            Optional.ofNullable(source.getComplaintType()).ifPresent(e -> row.put("complaintType", Parameter.from(e)));
            Optional.ofNullable(source.getReportLineIndex()).ifPresent(e -> row.put("reportLineIndex", Parameter.from(e)));
            Optional.ofNullable(source.getClosedBy()).ifPresent(e -> row.put("closedBy", Parameter.from(e)));
            Optional.ofNullable(source.getAssignedTo()).ifPresent(e -> row.put("assignedTo", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
