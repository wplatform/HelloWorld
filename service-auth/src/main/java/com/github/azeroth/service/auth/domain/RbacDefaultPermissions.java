package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("rbac_default_permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RbacDefaultPermissions {
    
    @Id
    @Column("secId")
    private Long secId;
    
    @Column("permissionId")
    private Long permissionId;
    
    @Column("realmId")
    private Integer realmId;
}
