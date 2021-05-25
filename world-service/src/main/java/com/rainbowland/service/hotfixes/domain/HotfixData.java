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
@Table("hotfix_data")
public class HotfixData {

    @Column("Id")
    private Integer id;
    @Column("TableHash")
    private Integer tableHash;
    @Column("RecordId")
    private Integer recordId;
    @Column("Status")
    private Integer status;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, HotfixData> {

        public HotfixData convert(Row row) {
            HotfixData domain = new HotfixData();
            domain.setId(row.get("Id", Integer.class));
            domain.setTableHash(row.get("TableHash", Integer.class));
            domain.setRecordId(row.get("RecordId", Integer.class));
            domain.setStatus(row.get("Status", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<HotfixData, OutboundRow> {

        public OutboundRow convert(HotfixData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getTableHash()).ifPresent(e -> row.put("TableHash", Parameter.from(e)));
            Optional.ofNullable(source.getRecordId()).ifPresent(e -> row.put("RecordId", Parameter.from(e)));
            Optional.ofNullable(source.getStatus()).ifPresent(e -> row.put("Status", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
