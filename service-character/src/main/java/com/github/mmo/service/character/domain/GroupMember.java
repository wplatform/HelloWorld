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
@Table(name = "group_member")
public class GroupMember {
    @Id
    @Column(name = "memberGuid", nullable = false)
    private Long id;

    @Column(name = "guid", columnDefinition = "int UNSIGNED not null")
    private Long guid;

    @ColumnDefault("'0'")
    @Column(name = "memberFlags", columnDefinition = "tinyint UNSIGNED not null")
    private Short memberFlags;

    @ColumnDefault("'0'")
    @Column(name = "subgroup", columnDefinition = "tinyint UNSIGNED not null")
    private Short subgroup;

    @ColumnDefault("'0'")
    @Column(name = "roles", columnDefinition = "tinyint UNSIGNED not null")
    private Short roles;

}