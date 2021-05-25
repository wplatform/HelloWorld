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
@Table("pet_levelstats")
public class PetLevelstats {

    @Column("creature_entry")
    private Integer creatureEntry;
    @Column("level")
    private Integer level;
    @Column("hp")
    private Integer hp;
    @Column("mana")
    private Integer mana;
    @Column("armor")
    private Integer armor;
    @Column("str")
    private Integer str;
    @Column("agi")
    private Integer agi;
    @Column("sta")
    private Integer sta;
    @Column("inte")
    private Integer inte;
    @Column("spi")
    private Integer spi;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PetLevelstats> {

        public PetLevelstats convert(Row row) {
            PetLevelstats domain = new PetLevelstats();
            domain.setCreatureEntry(row.get("creature_entry", Integer.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setHp(row.get("hp", Integer.class));
            domain.setMana(row.get("mana", Integer.class));
            domain.setArmor(row.get("armor", Integer.class));
            domain.setStr(row.get("str", Integer.class));
            domain.setAgi(row.get("agi", Integer.class));
            domain.setSta(row.get("sta", Integer.class));
            domain.setInte(row.get("inte", Integer.class));
            domain.setSpi(row.get("spi", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PetLevelstats, OutboundRow> {

        public OutboundRow convert(PetLevelstats source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureEntry()).ifPresent(e -> row.put("creature_entry", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getHp()).ifPresent(e -> row.put("hp", Parameter.from(e)));
            Optional.ofNullable(source.getMana()).ifPresent(e -> row.put("mana", Parameter.from(e)));
            Optional.ofNullable(source.getArmor()).ifPresent(e -> row.put("armor", Parameter.from(e)));
            Optional.ofNullable(source.getStr()).ifPresent(e -> row.put("str", Parameter.from(e)));
            Optional.ofNullable(source.getAgi()).ifPresent(e -> row.put("agi", Parameter.from(e)));
            Optional.ofNullable(source.getSta()).ifPresent(e -> row.put("sta", Parameter.from(e)));
            Optional.ofNullable(source.getInte()).ifPresent(e -> row.put("inte", Parameter.from(e)));
            Optional.ofNullable(source.getSpi()).ifPresent(e -> row.put("spi", Parameter.from(e)));
            return row;
        }
    }

}
