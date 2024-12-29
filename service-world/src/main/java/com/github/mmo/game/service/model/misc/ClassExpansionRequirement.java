package com.github.mmo.game.service.model.misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;

@Data
@AllArgsConstructor
public class ClassExpansionRequirement {
    public byte classID;
    public byte raceID;
    public byte activeExpansionLevel;
    public byte accountExpansionLevel;

}