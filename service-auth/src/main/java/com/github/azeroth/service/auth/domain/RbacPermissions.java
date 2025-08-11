package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("rbac_permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RbacPermissions {
    
    @Id
    @Column("id")
    private Long id;
    
    @Column("name")
    private String name;
}
