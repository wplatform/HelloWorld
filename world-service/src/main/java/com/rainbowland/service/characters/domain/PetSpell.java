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
@Table("pet_spell")
public class PetSpell {

    @Column("guid")
    private Integer guid;
    @Column("spell")
    private Integer spell;
    @Column("active")
    private Integer active;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PetSpell> {

        public PetSpell convert(Row row) {
            PetSpell domain = new PetSpell();
            domain.setGuid(row.get("guid", Integer.class));
            domain.setSpell(row.get("spell", Integer.class));
            domain.setActive(row.get("active", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PetSpell, OutboundRow> {

        public OutboundRow convert(PetSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getSpell()).ifPresent(e -> row.put("spell", Parameter.from(e)));
            Optional.ofNullable(source.getActive()).ifPresent(e -> row.put("active", Parameter.from(e)));
            return row;
        }
    }

}
