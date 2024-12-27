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
@Table(name = "petition")
public class Petition {
    @Id
    @Column(name = "ownerguid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "petitionguid")
    private Long petitionguid;

    @Column(name = "name", nullable = false, length = 24)
    private String name;

}