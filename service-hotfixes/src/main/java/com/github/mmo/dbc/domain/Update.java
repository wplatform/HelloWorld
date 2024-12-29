package com.github.mmo.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.Instant;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)

@Table(name = "updates")
public class Update {
    @Id
    @Column("name")
    private String name;


    @Column("hash")
    private String hash;



    @Column("state")
    private String state;


    @Column("timestamp")
    private Instant timestamp;


    @Column("speed")
    private Long speed;

}