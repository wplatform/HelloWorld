package com.github.azeroth.service.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "build_auth_key")
public class BuildAuthKey {
    @Id
    @Column("build")
    private Integer build;

    @Id
    @Column("platform")
    private Integer platform;

    @Column("key")
    private String key;
}