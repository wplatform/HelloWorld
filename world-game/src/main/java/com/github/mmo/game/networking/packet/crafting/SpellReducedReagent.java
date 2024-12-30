package com.github.mmo.game.networking.packet.crafting;

import com.github.mmo.game.networking.WorldPacket;

final class SpellReducedReagent {
    public int itemID;
    public int quantity;

    public void write(WorldPacket data) {
        data.writeInt32(itemID);
        data.writeInt32(quantity);
    }

    public SpellReducedReagent clone() {
        SpellReducedReagent varCopy = new SpellReducedReagent();

        varCopy.itemID = this.itemID;
        varCopy.quantity = this.quantity;

        return varCopy;
    }
}
