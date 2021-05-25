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
@Table("corpse_customizations")
public class CorpseCustomizations {

    @Column("ownerGuid")
    private Long ownerGuid;
    @Column("chrCustomizationOptionID")
    private Integer chrCustomizationOptionId;
    @Column("chrCustomizationChoiceID")
    private Integer chrCustomizationChoiceId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CorpseCustomizations> {

        public CorpseCustomizations convert(Row row) {
            CorpseCustomizations domain = new CorpseCustomizations();
            domain.setOwnerGuid(row.get("ownerGuid", Long.class));
            domain.setChrCustomizationOptionId(row.get("chrCustomizationOptionID", Integer.class));
            domain.setChrCustomizationChoiceId(row.get("chrCustomizationChoiceID", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CorpseCustomizations, OutboundRow> {

        public OutboundRow convert(CorpseCustomizations source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getOwnerGuid()).ifPresent(e -> row.put("ownerGuid", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationOptionId()).ifPresent(e -> row.put("chrCustomizationOptionID", Parameter.from(e)));
            Optional.ofNullable(source.getChrCustomizationChoiceId()).ifPresent(e -> row.put("chrCustomizationChoiceID", Parameter.from(e)));
            return row;
        }
    }

}
