package com.github.mmo.game.service.domain.misc;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "race_unlock_requirement")
public class RaceUnlockRequirement {
    @Id
    public Short id;

    @Column(value = "expansion")
    public Short expansion;

    @Column(value = "achievementId")
    public Integer achievementId;

}