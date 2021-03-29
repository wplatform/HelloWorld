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
@Table("rbac_linked_permissions")
public class RbacLinkedPermission {

    @Column("id")
    private Long id;
    @Column("linkedId")
    private Long linkedId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RbacLinkedPermission> {

        public RbacLinkedPermission convert(Row row) {
            RbacLinkedPermission domain = new RbacLinkedPermission();
            domain.setId(row.get("id", Long.class));
            domain.setLinkedId(row.get("linkedId", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RbacLinkedPermission, OutboundRow> {

        public OutboundRow convert(RbacLinkedPermission source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getLinkedId()).ifPresent(e -> row.put("linkedId", Parameter.from(e)));
            return row;
        }
    }

}
