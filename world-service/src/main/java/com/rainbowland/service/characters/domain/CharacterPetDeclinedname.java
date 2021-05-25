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
@Table("character_pet_declinedname")
public class CharacterPetDeclinedname {

    @Column("id")
    private Integer id;
    @Column("owner")
    private Integer owner;
    @Column("genitive")
    private String genitive;
    @Column("dative")
    private String dative;
    @Column("accusative")
    private String accusative;
    @Column("instrumental")
    private String instrumental;
    @Column("prepositional")
    private String prepositional;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterPetDeclinedname> {

        public CharacterPetDeclinedname convert(Row row) {
            CharacterPetDeclinedname domain = new CharacterPetDeclinedname();
            domain.setId(row.get("id", Integer.class));
            domain.setOwner(row.get("owner", Integer.class));
            domain.setGenitive(row.get("genitive", String.class));
            domain.setDative(row.get("dative", String.class));
            domain.setAccusative(row.get("accusative", String.class));
            domain.setInstrumental(row.get("instrumental", String.class));
            domain.setPrepositional(row.get("prepositional", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterPetDeclinedname, OutboundRow> {

        public OutboundRow convert(CharacterPetDeclinedname source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getOwner()).ifPresent(e -> row.put("owner", Parameter.from(e)));
            Optional.ofNullable(source.getGenitive()).ifPresent(e -> row.put("genitive", Parameter.from(e)));
            Optional.ofNullable(source.getDative()).ifPresent(e -> row.put("dative", Parameter.from(e)));
            Optional.ofNullable(source.getAccusative()).ifPresent(e -> row.put("accusative", Parameter.from(e)));
            Optional.ofNullable(source.getInstrumental()).ifPresent(e -> row.put("instrumental", Parameter.from(e)));
            Optional.ofNullable(source.getPrepositional()).ifPresent(e -> row.put("prepositional", Parameter.from(e)));
            return row;
        }
    }

}
