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
@Table("map_difficulty_x_condition")
public class MapDifficultyXCondition {

    @Column("ID")
    private Integer id;
    @Column("FailureDescription")
    private String failureDescription;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("MapDifficultyID")
    private Integer mapDifficultyId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MapDifficultyXCondition> {

        public MapDifficultyXCondition convert(Row row) {
            MapDifficultyXCondition domain = new MapDifficultyXCondition();
            domain.setId(row.get("ID", Integer.class));
            domain.setFailureDescription(row.get("FailureDescription", String.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setMapDifficultyId(row.get("MapDifficultyID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MapDifficultyXCondition, OutboundRow> {

        public OutboundRow convert(MapDifficultyXCondition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFailureDescription()).ifPresent(e -> row.put("FailureDescription", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getMapDifficultyId()).ifPresent(e -> row.put("MapDifficultyID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
