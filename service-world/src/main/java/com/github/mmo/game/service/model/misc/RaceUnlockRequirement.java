package com.github.mmo.game.service.model.misc;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

public class RaceUnlockRequirement {
    public short raceId;
    public short expansion;
    public int achievementId;

}