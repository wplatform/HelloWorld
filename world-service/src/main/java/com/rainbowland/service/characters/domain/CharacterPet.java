package com.rainbowland.service.characters.domain;

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
@Table("character_pet")
public class CharacterPet {

    @Column("id")
    private Integer id;
    @Column("entry")
    private Integer entry;
    @Column("owner")
    private Long owner;
    @Column("modelid")
    private Integer modelid;
    @Column("CreatedBySpell")
    private Integer createdBySpell;
    @Column("PetType")
    private Integer petType;
    @Column("level")
    private Integer level;
    @Column("exp")
    private Integer exp;
    @Column("Reactstate")
    private Integer reactstate;
    @Column("name")
    private String name;
    @Column("renamed")
    private Integer renamed;
    @Column("slot")
    private Integer slot;
    @Column("curhealth")
    private Integer curhealth;
    @Column("curmana")
    private Integer curmana;
    @Column("savetime")
    private Integer savetime;
    @Column("abdata")
    private String abdata;
    @Column("specialization")
    private Integer specialization;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterPet> {

        public CharacterPet convert(Row row) {
            CharacterPet domain = new CharacterPet();
            domain.setId(row.get("id", Integer.class));
            domain.setEntry(row.get("entry", Integer.class));
            domain.setOwner(row.get("owner", Long.class));
            domain.setModelid(row.get("modelid", Integer.class));
            domain.setCreatedBySpell(row.get("CreatedBySpell", Integer.class));
            domain.setPetType(row.get("PetType", Integer.class));
            domain.setLevel(row.get("level", Integer.class));
            domain.setExp(row.get("exp", Integer.class));
            domain.setReactstate(row.get("Reactstate", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setRenamed(row.get("renamed", Integer.class));
            domain.setSlot(row.get("slot", Integer.class));
            domain.setCurhealth(row.get("curhealth", Integer.class));
            domain.setCurmana(row.get("curmana", Integer.class));
            domain.setSavetime(row.get("savetime", Integer.class));
            domain.setAbdata(row.get("abdata", String.class));
            domain.setSpecialization(row.get("specialization", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterPet, OutboundRow> {

        public OutboundRow convert(CharacterPet source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getOwner()).ifPresent(e -> row.put("owner", Parameter.from(e)));
            Optional.ofNullable(source.getModelid()).ifPresent(e -> row.put("modelid", Parameter.from(e)));
            Optional.ofNullable(source.getCreatedBySpell()).ifPresent(e -> row.put("CreatedBySpell", Parameter.from(e)));
            Optional.ofNullable(source.getPetType()).ifPresent(e -> row.put("PetType", Parameter.from(e)));
            Optional.ofNullable(source.getLevel()).ifPresent(e -> row.put("level", Parameter.from(e)));
            Optional.ofNullable(source.getExp()).ifPresent(e -> row.put("exp", Parameter.from(e)));
            Optional.ofNullable(source.getReactstate()).ifPresent(e -> row.put("Reactstate", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getRenamed()).ifPresent(e -> row.put("renamed", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("slot", Parameter.from(e)));
            Optional.ofNullable(source.getCurhealth()).ifPresent(e -> row.put("curhealth", Parameter.from(e)));
            Optional.ofNullable(source.getCurmana()).ifPresent(e -> row.put("curmana", Parameter.from(e)));
            Optional.ofNullable(source.getSavetime()).ifPresent(e -> row.put("savetime", Parameter.from(e)));
            Optional.ofNullable(source.getAbdata()).ifPresent(e -> row.put("abdata", Parameter.from(e)));
            Optional.ofNullable(source.getSpecialization()).ifPresent(e -> row.put("specialization", Parameter.from(e)));
            return row;
        }
    }

}
