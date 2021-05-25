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
@Table("transmog_holiday")
public class TransmogHoliday {

    @Column("ID")
    private Integer id;
    @Column("RequiredTransmogHoliday")
    private Integer requiredTransmogHoliday;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TransmogHoliday> {

        public TransmogHoliday convert(Row row) {
            TransmogHoliday domain = new TransmogHoliday();
            domain.setId(row.get("ID", Integer.class));
            domain.setRequiredTransmogHoliday(row.get("RequiredTransmogHoliday", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TransmogHoliday, OutboundRow> {

        public OutboundRow convert(TransmogHoliday source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredTransmogHoliday()).ifPresent(e -> row.put("RequiredTransmogHoliday", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
