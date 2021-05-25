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
@Table("creature_formations")
public class CreatureFormations {

    @Column("leaderGUID")
    private Long leaderGuid;
    @Column("memberGUID")
    private Long memberGuid;
    @Column("dist")
    private Double dist;
    @Column("angle")
    private Double angle;
    @Column("groupAI")
    private Integer groupAi;
    @Column("point_1")
    private Integer point1;
    @Column("point_2")
    private Integer point2;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureFormations> {

        public CreatureFormations convert(Row row) {
            CreatureFormations domain = new CreatureFormations();
            domain.setLeaderGuid(row.get("leaderGUID", Long.class));
            domain.setMemberGuid(row.get("memberGUID", Long.class));
            domain.setDist(row.get("dist", Double.class));
            domain.setAngle(row.get("angle", Double.class));
            domain.setGroupAi(row.get("groupAI", Integer.class));
            domain.setPoint1(row.get("point_1", Integer.class));
            domain.setPoint2(row.get("point_2", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureFormations, OutboundRow> {

        public OutboundRow convert(CreatureFormations source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getLeaderGuid()).ifPresent(e -> row.put("leaderGUID", Parameter.from(e)));
            Optional.ofNullable(source.getMemberGuid()).ifPresent(e -> row.put("memberGUID", Parameter.from(e)));
            Optional.ofNullable(source.getDist()).ifPresent(e -> row.put("dist", Parameter.from(e)));
            Optional.ofNullable(source.getAngle()).ifPresent(e -> row.put("angle", Parameter.from(e)));
            Optional.ofNullable(source.getGroupAi()).ifPresent(e -> row.put("groupAI", Parameter.from(e)));
            Optional.ofNullable(source.getPoint1()).ifPresent(e -> row.put("point_1", Parameter.from(e)));
            Optional.ofNullable(source.getPoint2()).ifPresent(e -> row.put("point_2", Parameter.from(e)));
            return row;
        }
    }

}
