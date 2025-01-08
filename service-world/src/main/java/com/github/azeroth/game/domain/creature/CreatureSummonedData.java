package com.github.azeroth.game.domain.creature;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatureSummonedData {

    public int creatureID;
    public Integer creatureIdVisibleToSummoner;
    public Integer groundMountDisplayId;
    public Integer flyingMountDisplayId;

}
