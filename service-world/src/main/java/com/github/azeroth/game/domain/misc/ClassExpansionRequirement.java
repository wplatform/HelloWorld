package com.github.azeroth.game.domain.misc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassExpansionRequirement {
    public byte classID;
    public byte raceID;
    public byte activeExpansionLevel;
    public byte accountExpansionLevel;

}