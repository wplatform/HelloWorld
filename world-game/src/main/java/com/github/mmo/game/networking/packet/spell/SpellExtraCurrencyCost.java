package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.WorldPacket;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class SpellExtraCurrencyCost {
    public int currencyID;
    public int count;

    public void read(WorldPacket data) {
        currencyID = data.readInt32();
        count = data.readInt32();
    }

    public SpellExtraCurrencyCost clone() {
        SpellExtraCurrencyCost varCopy = new SpellExtraCurrencyCost();

        varCopy.currencyID = this.currencyID;
        varCopy.count = this.count;

        return varCopy;
    }
}
