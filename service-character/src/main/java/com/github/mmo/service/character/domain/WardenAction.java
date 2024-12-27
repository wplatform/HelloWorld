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
@Table(name = "warden_action")
public class WardenAction {
    @Id
    @Column(name = "wardenId", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;

    @Column(name = "action", columnDefinition = "tinyint UNSIGNED")
    private Short action;

}