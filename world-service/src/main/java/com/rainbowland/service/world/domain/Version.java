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
@Table("version")
public class Version {

    @Column("core_version")
    private String coreVersion;
    @Column("core_revision")
    private String coreRevision;
    @Column("db_version")
    private String dbVersion;
    @Column("cache_id")
    private Integer cacheId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Version> {

        public Version convert(Row row) {
            Version domain = new Version();
            domain.setCoreVersion(row.get("core_version", String.class));
            domain.setCoreRevision(row.get("core_revision", String.class));
            domain.setDbVersion(row.get("db_version", String.class));
            domain.setCacheId(row.get("cache_id", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Version, OutboundRow> {

        public OutboundRow convert(Version source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCoreVersion()).ifPresent(e -> row.put("core_version", Parameter.from(e)));
            Optional.ofNullable(source.getCoreRevision()).ifPresent(e -> row.put("core_revision", Parameter.from(e)));
            Optional.ofNullable(source.getDbVersion()).ifPresent(e -> row.put("db_version", Parameter.from(e)));
            Optional.ofNullable(source.getCacheId()).ifPresent(e -> row.put("cache_id", Parameter.from(e)));
            return row;
        }
    }

}
