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
@Table("petition")
public class Petition {

    @Column("ownerguid")
    private Long ownerguid;
    @Column("petitionguid")
    private Long petitionguid;
    @Column("name")
    private String name;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Petition> {

        public Petition convert(Row row) {
            Petition domain = new Petition();
            domain.setOwnerguid(row.get("ownerguid", Long.class));
            domain.setPetitionguid(row.get("petitionguid", Long.class));
            domain.setName(row.get("name", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Petition, OutboundRow> {

        public OutboundRow convert(Petition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getOwnerguid()).ifPresent(e -> row.put("ownerguid", Parameter.from(e)));
            Optional.ofNullable(source.getPetitionguid()).ifPresent(e -> row.put("petitionguid", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            return row;
        }
    }

}
