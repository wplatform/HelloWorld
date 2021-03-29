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
@Table("rbac_account_permissions")
public class RbacAccountPermission {

    @Column("accountId")
    private Long accountId;
    @Column("permissionId")
    private Long permissionId;
    @Column("granted")
    private Integer granted;
    @Column("realmId")
    private Integer realmId;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RbacAccountPermission> {

        public RbacAccountPermission convert(Row row) {
            RbacAccountPermission domain = new RbacAccountPermission();
            domain.setAccountId(row.get("accountId", Long.class));
            domain.setPermissionId(row.get("permissionId", Long.class));
            domain.setGranted(row.get("granted", Integer.class));
            domain.setRealmId(row.get("realmId", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RbacAccountPermission, OutboundRow> {

        public OutboundRow convert(RbacAccountPermission source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("accountId", Parameter.from(e)));
            Optional.ofNullable(source.getPermissionId()).ifPresent(e -> row.put("permissionId", Parameter.from(e)));
            Optional.ofNullable(source.getGranted()).ifPresent(e -> row.put("granted", Parameter.from(e)));
            Optional.ofNullable(source.getRealmId()).ifPresent(e -> row.put("realmId", Parameter.from(e)));
            return row;
        }
    }

}
