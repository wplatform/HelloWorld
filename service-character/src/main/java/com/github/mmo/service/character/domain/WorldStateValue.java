package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "world_state_value")
public class WorldStateValue {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Value", nullable = false)
    private Integer value;

}