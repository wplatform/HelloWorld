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
@Table("spawn_group_template")
public class SpawnGroupTemplate {

    @Column("groupId")
    private Integer groupId;
    @Column("groupName")
    private String groupName;
    @Column("groupFlags")
    private Integer groupFlags;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpawnGroupTemplate> {

        public SpawnGroupTemplate convert(Row row) {
            SpawnGroupTemplate domain = new SpawnGroupTemplate();
            domain.setGroupId(row.get("groupId", Integer.class));
            domain.setGroupName(row.get("groupName", String.class));
            domain.setGroupFlags(row.get("groupFlags", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpawnGroupTemplate, OutboundRow> {

        public OutboundRow convert(SpawnGroupTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGroupId()).ifPresent(e -> row.put("groupId", Parameter.from(e)));
            Optional.ofNullable(source.getGroupName()).ifPresent(e -> row.put("groupName", Parameter.from(e)));
            Optional.ofNullable(source.getGroupFlags()).ifPresent(e -> row.put("groupFlags", Parameter.from(e)));
            return row;
        }
    }

}
