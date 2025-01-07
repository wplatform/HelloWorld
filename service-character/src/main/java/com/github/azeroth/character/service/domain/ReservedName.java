package com.github.azeroth.character.service.domain;

import org.springframework.data.relational.core.mapping.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Table(name = "reserved_name")
public class ReservedName {
    @Id
    
    @Column("name")
    private String name;

    //TODO [Reverse Engineering] generate columns from DB
}