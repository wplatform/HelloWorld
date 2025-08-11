package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("realmcharacters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Realmcharacters {
    
    @Id
    @Column("realmid")
    private Integer realmId;
    
    @Column("acctid")
    private Long acctId;
    
    @Column("numchars")
    private Byte numChars;
}
