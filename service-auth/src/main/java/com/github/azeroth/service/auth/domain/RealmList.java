package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("realmlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealmList {
    
    @Id
    @Column("id")
    private Long id;
    
    @Column("name")
    private String name;
    
    @Column("address")
    private String address;
    
    @Column("localAddress")
    private String localAddress;
    
    @Column("localSubnetMask")
    private String localSubnetMask;
    
    @Column("port")
    private Short port;
    
    @Column("icon")
    private Byte icon;
    
    @Column("flag")
    private Byte flag;
    
    @Column("timezone")
    private Byte timezone;
    
    @Column("allowedSecurityLevel")
    private Byte allowedSecurityLevel;
    
    @Column("population")
    private Float population;
    
    @Column("gamebuild")
    private Long gamebuild;
    
    @Column("Region")
    private Byte region;
    
    @Column("Battlegroup")
    private Byte battlegroup;
}