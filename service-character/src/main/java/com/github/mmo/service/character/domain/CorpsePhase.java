package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CorpsePhaseId.class)
@Entity
@Table(name = "corpse_phases")
public class CorpsePhase {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "OwnerGuid", nullable = false)
    private Long ownerGuid;

    @Id
    @Column(name = "PhaseId", columnDefinition = "int UNSIGNED not null")
    private Long phaseId;

}