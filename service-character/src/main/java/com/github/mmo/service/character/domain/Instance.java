package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "instance")
public class Instance {
    @Id
    @Column(name = "instanceId", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Lob
    @Column(name = "data")
    private String data;

    @Column(name = "completedEncountersMask", columnDefinition = "int UNSIGNED")
    private Long completedEncountersMask;

    @Column(name = "entranceWorldSafeLocId", columnDefinition = "int UNSIGNED")
    private Long entranceWorldSafeLocId;

}