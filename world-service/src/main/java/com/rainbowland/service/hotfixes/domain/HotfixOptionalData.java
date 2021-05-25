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
@Table("hotfix_optional_data")
public class HotfixOptionalData {

    @Column("TableHash")
    private Integer tableHash;
    @Column("RecordId")
    private Integer recordId;
    @Column("locale")
    private String locale;
    @Column("Key")
    private Integer key;
    @Column("Data")
    private String data;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, HotfixOptionalData> {

        public HotfixOptionalData convert(Row row) {
            HotfixOptionalData domain = new HotfixOptionalData();
            domain.setTableHash(row.get("TableHash", Integer.class));
            domain.setRecordId(row.get("RecordId", Integer.class));
            domain.setLocale(row.get("locale", String.class));
            domain.setKey(row.get("Key", Integer.class));
            domain.setData(row.get("Data", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<HotfixOptionalData, OutboundRow> {

        public OutboundRow convert(HotfixOptionalData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getTableHash()).ifPresent(e -> row.put("TableHash", Parameter.from(e)));
            Optional.ofNullable(source.getRecordId()).ifPresent(e -> row.put("RecordId", Parameter.from(e)));
            Optional.ofNullable(source.getLocale()).ifPresent(e -> row.put("locale", Parameter.from(e)));
            Optional.ofNullable(source.getKey()).ifPresent(e -> row.put("Key", Parameter.from(e)));
            Optional.ofNullable(source.getData()).ifPresent(e -> row.put("Data", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
