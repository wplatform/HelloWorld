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
@Table("creature_model_info")
public class CreatureModelInfo {

    @Column("DisplayID")
    private Integer displayId;
    @Column("BoundingRadius")
    private Double boundingRadius;
    @Column("CombatReach")
    private Double combatReach;
    @Column("DisplayID_Other_Gender")
    private Integer displayIdOtherGender;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureModelInfo> {

        public CreatureModelInfo convert(Row row) {
            CreatureModelInfo domain = new CreatureModelInfo();
            domain.setDisplayId(row.get("DisplayID", Integer.class));
            domain.setBoundingRadius(row.get("BoundingRadius", Double.class));
            domain.setCombatReach(row.get("CombatReach", Double.class));
            domain.setDisplayIdOtherGender(row.get("DisplayID_Other_Gender", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureModelInfo, OutboundRow> {

        public OutboundRow convert(CreatureModelInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDisplayId()).ifPresent(e -> row.put("DisplayID", Parameter.from(e)));
            Optional.ofNullable(source.getBoundingRadius()).ifPresent(e -> row.put("BoundingRadius", Parameter.from(e)));
            Optional.ofNullable(source.getCombatReach()).ifPresent(e -> row.put("CombatReach", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayIdOtherGender()).ifPresent(e -> row.put("DisplayID_Other_Gender", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
