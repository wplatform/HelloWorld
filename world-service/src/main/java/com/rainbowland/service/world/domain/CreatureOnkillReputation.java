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
@Table("creature_onkill_reputation")
public class CreatureOnkillReputation {

    @Column("creature_id")
    private Integer creatureId;
    @Column("RewOnKillRepFaction1")
    private Integer rewOnKillRepFaction1;
    @Column("RewOnKillRepFaction2")
    private Integer rewOnKillRepFaction2;
    @Column("MaxStanding1")
    private Integer maxStanding1;
    @Column("IsTeamAward1")
    private Integer isTeamAward1;
    @Column("RewOnKillRepValue1")
    private Integer rewOnKillRepValue1;
    @Column("MaxStanding2")
    private Integer maxStanding2;
    @Column("IsTeamAward2")
    private Integer isTeamAward2;
    @Column("RewOnKillRepValue2")
    private Integer rewOnKillRepValue2;
    @Column("TeamDependent")
    private Integer teamDependent;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureOnkillReputation> {

        public CreatureOnkillReputation convert(Row row) {
            CreatureOnkillReputation domain = new CreatureOnkillReputation();
            domain.setCreatureId(row.get("creature_id", Integer.class));
            domain.setRewOnKillRepFaction1(row.get("RewOnKillRepFaction1", Integer.class));
            domain.setRewOnKillRepFaction2(row.get("RewOnKillRepFaction2", Integer.class));
            domain.setMaxStanding1(row.get("MaxStanding1", Integer.class));
            domain.setIsTeamAward1(row.get("IsTeamAward1", Integer.class));
            domain.setRewOnKillRepValue1(row.get("RewOnKillRepValue1", Integer.class));
            domain.setMaxStanding2(row.get("MaxStanding2", Integer.class));
            domain.setIsTeamAward2(row.get("IsTeamAward2", Integer.class));
            domain.setRewOnKillRepValue2(row.get("RewOnKillRepValue2", Integer.class));
            domain.setTeamDependent(row.get("TeamDependent", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureOnkillReputation, OutboundRow> {

        public OutboundRow convert(CreatureOnkillReputation source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("creature_id", Parameter.from(e)));
            Optional.ofNullable(source.getRewOnKillRepFaction1()).ifPresent(e -> row.put("RewOnKillRepFaction1", Parameter.from(e)));
            Optional.ofNullable(source.getRewOnKillRepFaction2()).ifPresent(e -> row.put("RewOnKillRepFaction2", Parameter.from(e)));
            Optional.ofNullable(source.getMaxStanding1()).ifPresent(e -> row.put("MaxStanding1", Parameter.from(e)));
            Optional.ofNullable(source.getIsTeamAward1()).ifPresent(e -> row.put("IsTeamAward1", Parameter.from(e)));
            Optional.ofNullable(source.getRewOnKillRepValue1()).ifPresent(e -> row.put("RewOnKillRepValue1", Parameter.from(e)));
            Optional.ofNullable(source.getMaxStanding2()).ifPresent(e -> row.put("MaxStanding2", Parameter.from(e)));
            Optional.ofNullable(source.getIsTeamAward2()).ifPresent(e -> row.put("IsTeamAward2", Parameter.from(e)));
            Optional.ofNullable(source.getRewOnKillRepValue2()).ifPresent(e -> row.put("RewOnKillRepValue2", Parameter.from(e)));
            Optional.ofNullable(source.getTeamDependent()).ifPresent(e -> row.put("TeamDependent", Parameter.from(e)));
            return row;
        }
    }

}
