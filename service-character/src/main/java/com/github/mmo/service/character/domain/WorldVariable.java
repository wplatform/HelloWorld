package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "world_variable")
public class WorldVariable {
    @Id
    @Column(name = "ID", nullable = false, length = 64)
    private String id;

    @ColumnDefault("0")
    @Column(name = "Value", nullable = false)
    private Integer value;

}