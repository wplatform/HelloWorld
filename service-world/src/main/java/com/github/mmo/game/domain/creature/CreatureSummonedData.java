package com.github.mmo.game.domain.creature;

public class CreatureSummonedData {
    private Integer creatureIdVisibleToSummoner = null;
    private Integer groundMountDisplayId = null;
    private Integer flyingMountDisplayId = null;

    public final Integer getCreatureIdVisibleToSummoner() {
        return creatureIdVisibleToSummoner;
    }

    public final void setCreatureIdVisibleToSummoner(Integer value) {
        creatureIdVisibleToSummoner = value;
    }

    public final Integer getGroundMountDisplayId() {
        return groundMountDisplayId;
    }

    public final void setGroundMountDisplayId(Integer value) {
        groundMountDisplayId = value;
    }

    public final Integer getFlyingMountDisplayId() {
        return flyingMountDisplayId;
    }

    public final void setFlyingMountDisplayId(Integer value) {
        flyingMountDisplayId = value;
    }
}
