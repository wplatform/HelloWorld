package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("rbac_account_permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RbacAccountPermissions {
    
    @Id
    @Column("accountId")
    private Long accountId;
    
    @Column("permissionId")
    private Long permissionId;
    
    @Column("granted")
    private Byte granted;
    
    @Column("realmId")
    private Integer realmId;
}
