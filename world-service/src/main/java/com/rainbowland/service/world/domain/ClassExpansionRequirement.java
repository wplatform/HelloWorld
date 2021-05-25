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
@Table("class_expansion_requirement")
public class ClassExpansionRequirement {

    @Column("ClassID")
    private Integer classId;
    @Column("RaceID")
    private Integer raceId;
    @Column("ActiveExpansionLevel")
    private Integer activeExpansionLevel;
    @Column("AccountExpansionLevel")
    private Integer accountExpansionLevel;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ClassExpansionRequirement> {

        public ClassExpansionRequirement convert(Row row) {
            ClassExpansionRequirement domain = new ClassExpansionRequirement();
            domain.setClassId(row.get("ClassID", Integer.class));
            domain.setRaceId(row.get("RaceID", Integer.class));
            domain.setActiveExpansionLevel(row.get("ActiveExpansionLevel", Integer.class));
            domain.setAccountExpansionLevel(row.get("AccountExpansionLevel", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ClassExpansionRequirement, OutboundRow> {

        public OutboundRow convert(ClassExpansionRequirement source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getClassId()).ifPresent(e -> row.put("ClassID", Parameter.from(e)));
            Optional.ofNullable(source.getRaceId()).ifPresent(e -> row.put("RaceID", Parameter.from(e)));
            Optional.ofNullable(source.getActiveExpansionLevel()).ifPresent(e -> row.put("ActiveExpansionLevel", Parameter.from(e)));
            Optional.ofNullable(source.getAccountExpansionLevel()).ifPresent(e -> row.put("AccountExpansionLevel", Parameter.from(e)));
            return row;
        }
    }

}
