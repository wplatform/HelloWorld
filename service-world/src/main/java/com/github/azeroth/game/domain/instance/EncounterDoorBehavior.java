package com.github.azeroth.game.domain.instance;

public enum EncounterDoorBehavior {
    OpenWhenNotInProgress, // open if encounter is not in progress
    OpenWhenDone         , // open if encounter is done
    OpenWhenInProgress   , // open if encounter is in progress, typically used for spawning places
    OpenWhenNotDone        // open if encounter is not done
}
