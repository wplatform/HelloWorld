package com.github.mmo.game.networking.packet.combatlog;

public final class SpellLogEffectFeedPetParams {
    public int itemID;

    public SpellLogEffectFeedPetParams clone() {
        SpellLogEffectFeedPetParams varCopy = new SpellLogEffectFeedPetParams();

        varCopy.itemID = this.itemID;

        return varCopy;
    }
}
