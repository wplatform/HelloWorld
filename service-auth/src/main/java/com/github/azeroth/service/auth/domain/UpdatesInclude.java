package com.github.azeroth.service.auth.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("updates_include")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatesInclude {
    
    @Id
    @Column("name")
    private String name;
    
    @Column("hash")
    private String hash;
    
    @Column("state")
    private String state;
    
    @Column("speed")
    private Integer speed;
}
