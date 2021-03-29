package com.rainbowland.service.auth.domain;

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
@Table("rbac_permissions")
public class RbacPermission {

    @Column("id")
    private Long id;
    @Column("name")
    private String name;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RbacPermission> {

        public RbacPermission convert(Row row) {
            RbacPermission domain = new RbacPermission();
            domain.setId(row.get("id", Long.class));
            domain.setName(row.get("name", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RbacPermission, OutboundRow> {

        public OutboundRow convert(RbacPermission source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            return row;
        }
    }

}
