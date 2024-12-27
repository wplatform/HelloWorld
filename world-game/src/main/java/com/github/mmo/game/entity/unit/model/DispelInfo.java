package com.github.mmo.game.entity.unit.model;

import com.github.mmo.world.entities.object.WorldObject;
import lombok.AllArgsConstructor;
import lombok.data;

@Data
@AllArgsConstructor
public
class DispelInfo {
    private WorldObject dispeller;
    private int dispellerSpell;
    private byte chargesRemoved;
}
