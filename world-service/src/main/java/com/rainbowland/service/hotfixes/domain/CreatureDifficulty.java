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
@Table("creature_difficulty")
public class CreatureDifficulty {

    @Column("ID")
    private Integer id;
    @Column("CreatureID")
    private Integer creatureId;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("Flags3")
    private Integer flags3;
    @Column("Flags4")
    private Integer flags4;
    @Column("Flags5")
    private Integer flags5;
    @Column("Flags6")
    private Integer flags6;
    @Column("Flags7")
    private Integer flags7;
    @Column("FactionTemplateID")
    private Integer factionTemplateId;
    @Column("Expansion")
    private Integer expansion;
    @Column("MinLevel")
    private Integer minLevel;
    @Column("MaxLevel")
    private Integer maxLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureDifficulty> {

        public CreatureDifficulty convert(Row row) {
            CreatureDifficulty domain = new CreatureDifficulty();
            domain.setId(row.get("ID", Integer.class));
            domain.setCreatureId(row.get("CreatureID", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setFlags3(row.get("Flags3", Integer.class));
            domain.setFlags4(row.get("Flags4", Integer.class));
            domain.setFlags5(row.get("Flags5", Integer.class));
            domain.setFlags6(row.get("Flags6", Integer.class));
            domain.setFlags7(row.get("Flags7", Integer.class));
            domain.setFactionTemplateId(row.get("FactionTemplateID", Integer.class));
            domain.setExpansion(row.get("Expansion", Integer.class));
            domain.setMinLevel(row.get("MinLevel", Integer.class));
            domain.setMaxLevel(row.get("MaxLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureDifficulty, OutboundRow> {

        public OutboundRow convert(CreatureDifficulty source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getFlags3()).ifPresent(e -> row.put("Flags3", Parameter.from(e)));
            Optional.ofNullable(source.getFlags4()).ifPresent(e -> row.put("Flags4", Parameter.from(e)));
            Optional.ofNullable(source.getFlags5()).ifPresent(e -> row.put("Flags5", Parameter.from(e)));
            Optional.ofNullable(source.getFlags6()).ifPresent(e -> row.put("Flags6", Parameter.from(e)));
            Optional.ofNullable(source.getFlags7()).ifPresent(e -> row.put("Flags7", Parameter.from(e)));
            Optional.ofNullable(source.getFactionTemplateId()).ifPresent(e -> row.put("FactionTemplateID", Parameter.from(e)));
            Optional.ofNullable(source.getExpansion()).ifPresent(e -> row.put("Expansion", Parameter.from(e)));
            Optional.ofNullable(source.getMinLevel()).ifPresent(e -> row.put("MinLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMaxLevel()).ifPresent(e -> row.put("MaxLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
