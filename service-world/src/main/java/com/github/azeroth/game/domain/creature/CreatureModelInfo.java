package com.github.azeroth.game.domain.creature;

import com.github.azeroth.defines.Gender;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatureModelInfo {
    public int displayId;
    public float boundingRadius;
    public float combatReach;
    public Gender gender;
    public int displayIdOtherGender;
    public boolean isTrigger;

    public CreatureModelInfo(int displayId, float boundingRadius, float combatReach, int gender, int displayIdOtherGender) {
        this.displayId = displayId;
        this.boundingRadius = boundingRadius;
        this.combatReach = combatReach;
        if (gender < 0 || gender > Gender.values().length) {
            this.gender = Gender.MALE;
        } else {
            this.gender = Gender.values()[gender];
        }
        this.gender = Gender.values()[gender];
        this.displayIdOtherGender = displayIdOtherGender;
    }
}
