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
@Table("rbac_default_permissions")
public class RbacDefaultPermission {

    @Column("secId")
    private Long secId;
    @Column("permissionId")
    private Long permissionId;
    @Column("realmId")
    private Integer realmId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RbacDefaultPermission> {

        public RbacDefaultPermission convert(Row row) {
            RbacDefaultPermission domain = new RbacDefaultPermission();
            domain.setSecId(row.get("secId", Long.class));
            domain.setPermissionId(row.get("permissionId", Long.class));
            domain.setRealmId(row.get("realmId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RbacDefaultPermission, OutboundRow> {

        public OutboundRow convert(RbacDefaultPermission source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSecId()).ifPresent(e -> row.put("secId", Parameter.from(e)));
            Optional.ofNullable(source.getPermissionId()).ifPresent(e -> row.put("permissionId", Parameter.from(e)));
            Optional.ofNullable(source.getRealmId()).ifPresent(e -> row.put("realmId", Parameter.from(e)));
            return row;
        }
    }

}
