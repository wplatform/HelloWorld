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
@Table(name = "reserved_name")
public class ReservedName {
    @Id
    @ColumnDefault("''")
    @Column(name = "name", nullable = false, length = 12)
    private String name;

    //TODO [Reverse Engineering] generate columns from DB
}