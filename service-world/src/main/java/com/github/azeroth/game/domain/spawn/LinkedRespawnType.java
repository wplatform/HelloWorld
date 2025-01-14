package com.github.azeroth.game.domain.spawn;

public enum LinkedRespawnType {

    CREATURE_TO_CREATURE,
    CREATURE_TO_GO, // Creature is dependant on GameObject
    GO_TO_GO,
    GO_TO_CREATURE         // GameObject is dependant on Creature

}
