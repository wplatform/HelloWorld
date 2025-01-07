package com.github.azeroth.game.domain.unit;

import com.github.azeroth.world.entities.object.WorldObject;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public
class DispelInfo {
    private WorldObject dispeller;
    private int dispellerSpell;
    private byte chargesRemoved;
}
