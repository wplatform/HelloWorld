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
@Table("lfg_dungeon_template")
public class LfgDungeonTemplate {

    @Column("dungeonId")
    private Integer dungeonId;
    @Column("name")
    private String name;
    @Column("position_x")
    private Double positionX;
    @Column("position_y")
    private Double positionY;
    @Column("position_z")
    private Double positionZ;
    @Column("orientation")
    private Double orientation;
    @Column("requiredItemLevel")
    private Integer requiredItemLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, LfgDungeonTemplate> {

        public LfgDungeonTemplate convert(Row row) {
            LfgDungeonTemplate domain = new LfgDungeonTemplate();
            domain.setDungeonId(row.get("dungeonId", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setPositionX(row.get("position_x", Double.class));
            domain.setPositionY(row.get("position_y", Double.class));
            domain.setPositionZ(row.get("position_z", Double.class));
            domain.setOrientation(row.get("orientation", Double.class));
            domain.setRequiredItemLevel(row.get("requiredItemLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<LfgDungeonTemplate, OutboundRow> {

        public OutboundRow convert(LfgDungeonTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDungeonId()).ifPresent(e -> row.put("dungeonId", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getPositionX()).ifPresent(e -> row.put("position_x", Parameter.from(e)));
            Optional.ofNullable(source.getPositionY()).ifPresent(e -> row.put("position_y", Parameter.from(e)));
            Optional.ofNullable(source.getPositionZ()).ifPresent(e -> row.put("position_z", Parameter.from(e)));
            Optional.ofNullable(source.getOrientation()).ifPresent(e -> row.put("orientation", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredItemLevel()).ifPresent(e -> row.put("requiredItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
