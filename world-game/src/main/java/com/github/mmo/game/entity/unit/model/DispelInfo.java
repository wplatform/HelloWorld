package com.github.mmo.game.entity.unit.model;

import com.github.mmo.world.entities.object.WorldObject;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public
class DispelInfo {
    private WorldObject dispeller;
    private int dispellerSpell;
    private byte chargesRemoved;
}
