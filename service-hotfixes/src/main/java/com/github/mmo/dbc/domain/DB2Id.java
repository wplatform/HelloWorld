package com.github.mmo.dbc.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DB2Id implements Serializable {
    public Long id;
    public Integer verifiedBuild;

}