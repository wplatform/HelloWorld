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
@Table("skill_race_class_info")
public class SkillRaceClassInfo {

    @Column("ID")
    private Integer id;
    @Column("RaceMask")
    private Long raceMask;
    @Column("SkillID")
    private Integer skillId;
    @Column("ClassMask")
    private Integer classMask;
    @Column("Flags")
    private Integer flags;
    @Column("Availability")
    private Integer availability;
    @Column("MinLevel")
    private Integer minLevel;
    @Column("SkillTierID")
    private Integer skillTierId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillRaceClassInfo> {

        public SkillRaceClassInfo convert(Row row) {
            SkillRaceClassInfo domain = new SkillRaceClassInfo();
            domain.setId(row.get("ID", Integer.class));
            domain.setRaceMask(row.get("RaceMask", Long.class));
            domain.setSkillId(row.get("SkillID", Integer.class));
            domain.setClassMask(row.get("ClassMask", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setAvailability(row.get("Availability", Integer.class));
            domain.setMinLevel(row.get("MinLevel", Integer.class));
            domain.setSkillTierId(row.get("SkillTierID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillRaceClassInfo, OutboundRow> {

        public OutboundRow convert(SkillRaceClassInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRaceMask()).ifPresent(e -> row.put("RaceMask", Parameter.from(e)));
            Optional.ofNullable(source.getSkillId()).ifPresent(e -> row.put("SkillID", Parameter.from(e)));
            Optional.ofNullable(source.getClassMask()).ifPresent(e -> row.put("ClassMask", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getAvailability()).ifPresent(e -> row.put("Availability", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevel()).ifPresent(e -> row.put("MinLevel", Parameter.from(e)));
            Optional.ofNullable(source.getSkillTierId()).ifPresent(e -> row.put("SkillTierID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
