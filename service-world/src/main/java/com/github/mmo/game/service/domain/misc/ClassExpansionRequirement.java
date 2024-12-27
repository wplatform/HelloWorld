package com.github.mmo.game.service.domain.misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;

@Data
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class ClassExpansionRequirement {
    public byte classID;
    public byte raceID;
    public byte activeExpansionLevel;
    public byte accountExpansionLevel;

}