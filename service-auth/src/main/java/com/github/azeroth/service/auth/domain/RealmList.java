package com.github.azeroth.service.auth.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table(name = "realmlist")
public class RealmList {
    @Id
    public Integer id;

    @Column(value = "name")
    public String name;

    @Column(value = "address")
    public String address;

    @Column(value = "localAddress")
    public String localAddress;

    @Column(value = "address3")
    public String address3;

    @Column(value = "address4")
    public String address4;

    @Column(value = "localSubnetMask")
    public String localSubnetMask;

    @Column(value = "port")
    public Integer port;

    @Column(value = "icon")
    public Short icon;

    @Column(value = "flag")
    public Short flag;

    @Column(value = "timezone")
    public Short timezone;

    @Column(value = "allowedSecurityLevel")
    public Short allowedSecurityLevel;

    @Column(value = "population")
    public Float population;

    @Column(value = "gamebuild")
    public Long gamebuild;

    @Column(value = "Region")
    public Short region;

    @Column(value = "Battlegroup")
    public Short battlegroup;

}