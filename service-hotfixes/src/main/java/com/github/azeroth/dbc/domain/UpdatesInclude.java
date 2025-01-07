package com.github.azeroth.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)

@Table(name = "updates_include")
public class UpdatesInclude {
    @Id
    @Column("path")
    private String path;


    
    @Column("state")
    private String state;

}