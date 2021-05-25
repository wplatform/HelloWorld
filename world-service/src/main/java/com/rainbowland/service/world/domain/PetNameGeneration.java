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
@Table("pet_name_generation")
public class PetNameGeneration {

    @Column("id")
    private Integer id;
    @Column("word")
    private String word;
    @Column("entry")
    private Integer entry;
    @Column("half")
    private Integer half;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PetNameGeneration> {

        public PetNameGeneration convert(Row row) {
            PetNameGeneration domain = new PetNameGeneration();
            domain.setId(row.get("id", Integer.class));
            domain.setWord(row.get("word", String.class));
            domain.setEntry(row.get("entry", Integer.class));
            domain.setHalf(row.get("half", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PetNameGeneration, OutboundRow> {

        public OutboundRow convert(PetNameGeneration source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getWord()).ifPresent(e -> row.put("word", Parameter.from(e)));
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getHalf()).ifPresent(e -> row.put("half", Parameter.from(e)));
            return row;
        }
    }

}
