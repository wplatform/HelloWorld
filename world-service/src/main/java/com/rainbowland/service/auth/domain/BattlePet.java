package com.rainbowland.service.auth.domain;

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
@Table("battle_pets")
public class BattlePet {

    @Column("guid")
    private Long guid;
    @Column("battlenetAccountId")
    private Long battlenetAccountId;
    @Column("species")
    private Integer species;
    @Column("breed")
    private Integer breed;
    @Column("level")
    private Integer level;
    @Column("exp")
    private Integer exp;
    @Column("health")
    private Integer health;
    @Column("quality")
    private Integer quality;
    @Column("flags")
    private Integer flags;
    @Column("name")
    private String name;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePet> {

        public BattlePet convert(Row row) {
            BattlePet domain = new BattlePet();
            domain.setGuid(row.get("guid", Long.class));
            domain.setBattlenetAccountId(row.get("battlenetAccountId", Long.class));
            domain.setSpecies(row.get("species", Integer.class));
            domain.setBreed(row.get("breed", Integer.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setExp(row.get("exp", Integer.class));
            domain.setHealth(row.get("health", Integer.class));
            domain.setQuality(row.get("quality", Integer.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setName(row.get("name", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePet, OutboundRow> {

        public OutboundRow convert(BattlePet source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getBattlenetAccountId()).ifPresent(e -> row.put("battlenetAccountId", Parameter.from(e)));
            Optional.ofNullable(source.getSpecies()).ifPresent(e -> row.put("species", Parameter.from(e)));
            Optional.ofNullable(source.getBreed()).ifPresent(e -> row.put("breed", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getExp()).ifPresent(e -> row.put("exp", Parameter.from(e)));
            Optional.ofNullable(source.getHealth()).ifPresent(e -> row.put("health", Parameter.from(e)));
            Optional.ofNullable(source.getQuality()).ifPresent(e -> row.put("quality", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            return row;
        }
    }

}
