package com.github.azeroth.game.domain.misc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InstanceEncounter {
    private int entry;
    private int creditType;
    private int creditEntry;
    private int lastEncounterDungeon;
}