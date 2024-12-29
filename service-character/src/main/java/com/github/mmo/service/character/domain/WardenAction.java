package com.github.mmo.service.character.domain;

import org.springframework.data.relational.core.mapping.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Table(name = "warden_action")
public class WardenAction {
    @Id
    @Column("wardenId")
    private int id;

    @Column("action")
    private Short action;

}