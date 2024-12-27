package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
public final class SpellModifierData {
    public double modifierValue;

    public byte classIndex;

    public void write(WorldPacket data) {
        data.writeFloat((float) modifierValue);
        data.writeInt8(classIndex);
    }

    public SpellModifierData clone() {
        SpellModifierData varCopy = new SpellModifierData();

        varCopy.modifierValue = this.modifierValue;
        varCopy.classIndex = this.classIndex;

        return varCopy;
    }
}
